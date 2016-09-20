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
	AbsenceExpression absence(ExpressionVariable p) {
		new AbsenceExpression(p)
	}
	
	ExistenceExpression existence(ExpressionVariable p) {
		new ExistenceExpression(p)
	}
	
	// TODO: number of occurrences not implemented yet
	BoundedExpression boundedExistence(ExpressionVariable p) {
		new BoundedExpression(p)
	}
	
	UniversalityExpression universality(ExpressionVariable p) {
		new UniversalityExpression(p)
	}
	
	PrecedenceExpression precedence(ExpressionVariable s) {
		new PrecedenceExpression(s)
	}
	
	ResponseExpression response(ExpressionVariable s) {
		new ResponseExpression(s)
	}
	
	PrecedenceChainExpression precedenceChain(ExpressionVariable s) {
		new PrecedenceChainExpression(s)
	}
	
	PrecedenceChainExpression precedenceChain(ExpressionVariable s, ExpressionVariable t) {
		new PrecedenceChainExpression(s, t)
	}
	
	ResponseChainExpression responseChain(ExpressionVariable p) {
		new ResponseChainExpression(p)
	}
	
	ResponseChainExpression responseChain(ExpressionVariable s, ExpressionVariable t) {
		new ResponseChainExpression(s, t)
	}
	
	ConstrainedChainExpression constrainedChain(ExpressionVariable s, ExpressionVariable t) {
		new ConstrainedChainExpression(s, t)
	}
}
