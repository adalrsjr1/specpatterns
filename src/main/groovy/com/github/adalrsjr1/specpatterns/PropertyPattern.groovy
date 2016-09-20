package com.github.adalrsjr1.specpatterns

import com.github.adalrsjr1.specpatterns.mappings.AbsenceExpression
import com.github.adalrsjr1.specpatterns.mappings.BoundedExpression
import com.github.adalrsjr1.specpatterns.mappings.ConstrainedChainExpression;
import com.github.adalrsjr1.specpatterns.mappings.ExistenceExpression
import com.github.adalrsjr1.specpatterns.mappings.PrecedenceChainExpression;
import com.github.adalrsjr1.specpatterns.mappings.PrecedenceExpression
import com.github.adalrsjr1.specpatterns.mappings.ResponseChainExpression;
import com.github.adalrsjr1.specpatterns.mappings.ResponseExpression;
import com.github.adalrsjr1.specpatterns.mappings.UniversalityExpression;

import groovy.util.logging.Slf4j

@Slf4j
class PropertyPattern {
	/**
	 * To describe a portion of a system's execution that is free of 
	 * certain events or states. Also known as <b>Never</b>.
	 * </br>
	 * </br>
	 * <b>Examples and Known Uses</b>
	 * </br>
	 * </br>
	 * The most common example is mutual exclusion. In a state-based model, 
	 * the scope would be global and P would be a state formula that is true 
	 * if more than one process is in its critical section. For an event-based model, 
	 * the scope would be a segment of the execution in which some process is in its 
	 * critical section (i.e., between an enter section event and a leave section event), 
	 * and P would be the event that some other process enters its critical section.
	 * @param p a variable
	 * @return a builder to create an AbsenceExpression
	 */
	AbsenceExpression absence(ExpressionVariable p) {
		new AbsenceExpression(p)
	}

	/**
	 * To describe a portion of a system's execution that contains an instance of 
	 * certain events or states. Also known as <b>Eventually</b>.
	 * </br>
	 * </br>
	 * <b>Examples and Known Uses</b>
	 * </br>
	 * </br>
	 * The classic example of existence is specifying termination, 
	 * e.g., on all executions do we eventually reach a terminal state.
	 * @param p a variable
	 * @return a builder to create an ExistenceExpression
	 */
	ExistenceExpression existence(ExpressionVariable p) {
		new ExistenceExpression(p)
	}

	/**
	 * To describe a portion of a system's execution that contains at most a specified number of instances of a designated state transition or event.
	 * 
	 * Examples and Known Uses
	 Bounded overtaking properties can naturally be expressed using instances of this pattern. For example, if we wish to say that process 1 can enter its critical region at most twice while process 2 is waiting to enter its region we would use a between scope (delimited by process 2 entering and exiting its waiting region) with 2-bounded existence for process 1 entering its critical region.
	 Mappings for bounds other than two can be constructed relatively simply from the given mappings. For QREs one simply defines k appropriately. For LTL and CTL we simply add additional copies of the nested until structures, for example in LTL 3-bounded global existence is:
	 (!P W (P W (!P W (P W (!P W (P W []!P))))))
	 (where the nested 2-bounded version is in bold).
	 If the weak-until operator is not available directly one can simply expand the mapping using the definition given above. For example, the 2-bounded global LTL mapping:
	 (!P W (P W (!P W (P W []!P))))
	 would become:
	 (!P U ([]!P | (P U ([]P | (!P U ([]!P | (P U ([]P | []!P))))))))
	 * @param p
	 * @return
	 */
	BoundedExpression boundedExistence(ExpressionVariable p) {
		new BoundedExpression(p)
	}

	/**
	 * To describe a portion of a system's execution which contains only states that have a desired property. Also known as Henceforth and Always.
	 * 
	 * Examples and Known Uses
	 This pattern can be applied in most situations where the absence pattern can be applied. This is especially true for state-based formalisms, e.g., where mutual exclusion could be formulated as absence or universality with a between scope.
	 * @param p
	 * @return
	 */
	UniversalityExpression universality(ExpressionVariable p) {
		new UniversalityExpression(p)
	}

	/**
	 * To describe relationships between a pair of events/states where the occurrence of the first is a necessary pre-condition for an occurrence of the second. We say that an occurrence of the second is enabled by an occurrence of the first.
	 * 
	 * Examples and Known Uses
	 Precedence properties occur quite commonly in specifications of concurrent systems. One common example is in describing a requirement that a resource is only granted in response to a request. 
	 * @param s
	 * @return
	 */
	PrecedenceExpression precedence(ExpressionVariable s) {
		new PrecedenceExpression(s)
	}


	/**
	 * To describe cause-effect relationships between a pair of events/states. An occurrence of the first, the cause, must be followed by an occurrence of the second, the effect. Also known as Follows and Leads-to.
	 * 
	 * Examples and Known Uses
	 Response properties occur quite commonly in specifications of concurrent systems. Perhaps the most common example is in describing a requirement that a resource must be granted after it is requested.
	 * @param s
	 * @return
	 */
	ResponseExpression response(ExpressionVariable s) {
		new ResponseExpression(s)
	}

	/**
	 * This is a scalable pattern. We describe the 1 cause - 2 effect version here.
	 To describe a relationship between an event/state P and a sequence of events/states (S, T) in which the occurrence of S followed by T within the scope must be preceded by an occurrence of the the sequence P within the same scope. In state-based formalisms, the beginning of the enabled sequence (S, T) may be satisfied by the same state as the enabling condition (i.e., P and S may be true in the same state).
	 Examples and Known Uses
	 An example of this pattern, assuming reliable communication between client and server, is that "If a client makes a request and there is no response, then the server must have crashed." This would be expressed by parameterizing the constrained variant of the 1-2 precedence chain pattern as:
	 ServerCrash precedes ClientRequest, []!Response without Response
	 in LTL.
	 * @param s
	 * @return
	 */
	PrecedenceChainExpression precedenceChain(ExpressionVariable s) {
		new PrecedenceChainExpression(s)
	}

	/**
	 * This is a scalable pattern. We describe the 1 cause - 2 effect version here.
	 To describe a relationship between an event/state P and a sequence of events/states (S, T) in which the occurrence of S followed by T within the scope must be preceded by an occurrence of the the sequence P within the same scope. In state-based formalisms, the beginning of the enabled sequence (S, T) may be satisfied by the same state as the enabling condition (i.e., P and S may be true in the same state).
	 Examples and Known Uses
	 An example of this pattern, assuming reliable communication between client and server, is that "If a client makes a request and there is no response, then the server must have crashed." This would be expressed by parameterizing the constrained variant of the 1-2 precedence chain pattern as:
	 ServerCrash precedes ClientRequest, []!Response without Response
	 in LTL. 
	 * @param s
	 * @param t
	 * @return
	 */
	PrecedenceChainExpression precedenceChain(ExpressionVariable s, ExpressionVariable t) {
		new PrecedenceChainExpression(s, t)
	}

	/**
	 * This is a scalable pattern. We describe the intent of the 1 stimulus - 2 response version here.
	 To describe a relationship between a stimulus event (P) and a sequence of two response events (S,T) in which the occurrence of the stimulus event must be followed by an occurrence of the sequence of response events within the scope. In state-based formalisms, the states satisfying the response must be distinct (i.e., S and T must be true in different states to count as a response), but the response may be satisfied by the same state as the stimulus (i.e., P and S may be true in the same state).
	 If a resource allocator grants a process access to a resource (GrantRes), the process will start using the resource (BeginRes) and finish using the resource (EndRes).
	 * @param p
	 * @return
	 */
	ResponseChainExpression responseChain(ExpressionVariable p) {
		new ResponseChainExpression(p)
	}

	/**
	 * This is a scalable pattern. We describe the intent of the 1 stimulus - 2 response version here.
	 To describe a relationship between a stimulus event (P) and a sequence of two response events (S,T) in which the occurrence of the stimulus event must be followed by an occurrence of the sequence of response events within the scope. In state-based formalisms, the states satisfying the response must be distinct (i.e., S and T must be true in different states to count as a response), but the response may be satisfied by the same state as the stimulus (i.e., P and S may be true in the same state).
	 If a resource allocator grants a process access to a resource (GrantRes), the process will start using the resource (BeginRes) and finish using the resource (EndRes).
	 * @param s
	 * @param t
	 * @return
	 */
	ResponseChainExpression responseChain(ExpressionVariable s, ExpressionVariable t) {
		new ResponseChainExpression(s, t)
	}

	/**
	 * To describe a variant of response and precedence chain patterns that 
	 * restrict user specified events from occurring between pairs of states/events 
	 * in the chain sequences.
	 * </br>
	 * Consecutive pairs of states/events in chain sequences are refered to as links. 
	 * This pattern allows specification of the absence of states/events from individual 
	 * links.
	 * </br>
	 * </br>
	 * <b>Examples and Known Uses</b>
	 * </br>
	 * </br>
	 * Constrained chain patterns are surprisingly useful. Some of our recent work with 
	 * model checking of GUI software used CTL mappings for constrained 1-2 response 
	 * patterns with global scope (e.g., AG(P -> AF(S & !Z & AX(A[!Z U T])))). In the 
	 * following, user indicates that the user is allowed to interact with the GUI, 
	 * select, print, help, ok, ... are interactions that the user can perform, and 
	 * error, address are system responses.
	 * </br>
	 * When a system error message is displayed the only allowable action is user 
	 * acknowledgement via the 'ok' button.
	 * </br>
	 *    AG(error -> AF(user & !(print | help | ...) & AX(A[!(print | help | ...) U ok])))
	 * </br>
	 * When the user selects a customer the address information is displayed before the 
	 * user is allowed another interaction .
	 * </br>
	 *   AG(select -> AF(!user & AX(A[!user U address])))
	 * </br>
	 * The latter example had !user filling the role of both S and !Z in the mapping and 
	 * it was simplified.
	 * @param s
	 * @param t
	 * @return
	 */
	ConstrainedChainExpression constrainedChain(ExpressionVariable s, ExpressionVariable t) {
		new ConstrainedChainExpression(s, t)
	}
}
