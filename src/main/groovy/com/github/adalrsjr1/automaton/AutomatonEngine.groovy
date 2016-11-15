package com.github.adalrsjr1.automaton;

import jhoafparser.ast.BooleanExpression
import jhoafparser.storage.StoredAutomaton
import jhoafparser.storage.StoredState

import java.util.Map
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.google.common.base.Stopwatch;

import groovy.transform.Memoized

public class AutomatonEngine {

	private static final Logger log = LoggerFactory.getLogger(AutomatonEngine.class)

	private StoredAutomaton storedAutomaton

	private Stopwatch timeInCurrentState
	private int currentState = 0
	private int lastState = 0

	private List<AutomatonListener> listeners = []
	
	AutomatonEngine(StoredAutomaton automaton) {
		storedAutomaton = automaton
		timeInCurrentState = Stopwatch.createStarted()
	}

	boolean isInAcceptanceState() {
		return (storedAutomaton.getStoredState(currentState).accSignature != null)
	}

	int getCurrentState() {
		return currentState
	}

	int getLastState() {
		return lastState
	}
	
	private void notify(AutomatonEvent event) {
		for(AutomatonListener listener in listeners) {
			listener.notify(event)
		}
	}
	
	void addListener(AutomatonListener listener) {
		listeners << listener
	}
	
	void removeListener(AutomatonListener listener) {
		listeners.remove(listener)
	}
	
	void clearListeners() {
		listeners.clear()
	}

	private void restartWatch() {
		timeInCurrentState.reset()
		timeInCurrentState.start()
	}
	
	void setCurrentState(int newCurrentState) {
		lastState = currentState
		currentState = newCurrentState
		notify(new AutomatonEvent(this, lastState, currentState, timeInCurrentState.elapsed(TimeUnit.MILLISECONDS), isInAcceptanceState()))
		restartWatch()
	}

	long timeElapsedInCurrentState(TimeUnit timeUnit) {
		timeInCurrentState.elapsed(timeUnit)
	}

	boolean transition(AutomatonTransitionEvent event) {
		def transitions = storedAutomaton.getEdgesWithLabel(currentState)
		Map content = event.getContent()
		for(transition in transitions) {
			boolean result = evaluate(transition.labelExpr, content)
			if(result) {
				setCurrentState(transition.conjSuccessors.first())
				return true
			}
		}
		return false
	}

	@Memoized
	private Map stringToMap(String token) {
		def splited = token.split(":")
		def map = [:]
		map[splited[0]] = splited[1]
		return map
	}

	@Memoized
	private boolean evaluate(BooleanExpression expression, Map toEvaluate) {
		BooleanExpression root = expression
		boolean leftResult = null, rightResult = null, result = true
		if(expression.left != null)
			leftResult = evaluate(expression.left, toEvaluate)

		if(expression.right != null)
			rightResult = evaluate(expression.right, toEvaluate)

		if(expression.left == null && expression.right == null && root != null) {
			if(root.type == BooleanExpression.Type.EXP_ATOM) {
				int nRoot = root.toString().toInteger()

				String token = storedAutomaton.storedHeader.APs[nRoot]
				Map mapToken = stringToMap(token)

				// if intersection is empty then there aren't correspondence
				return toEvaluate.intersect(mapToken).size() != 0

			}
			if(BooleanExpression.Type.EXP_TRUE == expression.type) {
				return true
			}
			if(BooleanExpression.Type.EXP_FALSE == expression.type) {
				return false
			}
		}

		if(BooleanExpression.Type.EXP_NOT == expression.type) {
			result = leftResult == null ? !rightResult : !leftResult

		}
		else if(BooleanExpression.Type.EXP_OR == expression.type) {
			result = leftResult || rightResult
		}
		else if(BooleanExpression.Type.EXP_AND == expression.type) {
			result = leftResult && rightResult
		}
		return result
	}
}