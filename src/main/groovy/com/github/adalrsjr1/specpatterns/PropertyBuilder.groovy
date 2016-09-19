package com.github.adalrsjr1.specpatterns

import groovy.util.logging.Slf4j

@Slf4j
class PropertyBuilder {
	List<ExpressionBuilder> expressions = []
	
	ExpressionBuilder absence(ExpressionVariable p) {
		ExpressionBuilder expressionBuilder = new ExpressionBuilder(ExpressionPattern.ABSENCE, p)
		expressions << expressionBuilder
		return expressionBuilder
	}
	
	ExpressionBuilder existence(ExpressionVariable p) {
		ExpressionBuilder expressionBuilder = new ExpressionBuilder(ExpressionPattern.EXISTENCE, p)
		expressions << expressionBuilder
		return expressionBuilder
	}
	
	ExpressionBuilder boundedExistence(ExpressionVariable p) {
		ExpressionBuilder expressionBuilder = new ExpressionBuilder(ExpressionPattern.BOUNDED_EXISTENCE, p)
		expressions << expressionBuilder
		return expressionBuilder
	}
	
	ExpressionBuilder universality(ExpressionVariable p) {
		ExpressionBuilder expressionBuilder = new ExpressionBuilder(ExpressionPattern.UNIVERSALITY, p)
		expressions << expressionBuilder
		return expressionBuilder
	}
	
	ExpressionBuilder precedence(ExpressionVariable p) {
		ExpressionBuilder expressionBuilder = new ExpressionBuilder(ExpressionPattern.PRECEDENCE, p)
		expressions << expressionBuilder
		return expressionBuilder
	}
	
	ExpressionBuilder response(ExpressionVariable p) {
		ExpressionBuilder expressionBuilder = new ExpressionBuilder(ExpressionPattern.RESPONSE, p)
		expressions << expressionBuilder
		return expressionBuilder
	}
	
	ExpressionBuilder precedenceChain(ExpressionVariable p) {
		ExpressionBuilder expressionBuilder = new ExpressionBuilder(ExpressionPattern.PRECEDENCE_CHAIN, p)
		expressions << expressionBuilder
		return expressionBuilder
	}
	
	ExpressionBuilder responseChain(ExpressionVariable p) {
		ExpressionBuilder expressionBuilder = new ExpressionBuilder(ExpressionPattern.RESPONSE_CHAIN, p)
		expressions << expressionBuilder
		return expressionBuilder
	}
	
	ExpressionBuilder constrainedChain(ExpressionVariable p) {
		ExpressionBuilder expressionBuilder = new ExpressionBuilder(ExpressionPattern.CONSTRAINED_CHAIN, p)
		expressions << expressionBuilder
		return expressionBuilder
	}
	
	void build() {
		log.debug "property building"
		expressions.collect {
			it.build()
		}
	}
}
