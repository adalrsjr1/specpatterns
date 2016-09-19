package com.github.adalrsjr1.specpatterns

import groovy.util.logging.Slf4j

@Slf4j
class And {
	ExpressionBuilder expressionBuilder
	String prefix
	ExpressionPattern pattern
	
	And(ExpressionBuilder expressionBuilder, ExpressionPattern pattern, String prefix) {
		this.expressionBuilder = expressionBuilder
		this.pattern = pattern
		this.prefix = prefix
	}
	
	ExpressionBuilder and(ExpressionVariable r) {
		expressionBuilder.instance = new PropertyInstance(pattern, "$prefix and $r")
		return expressionBuilder
	}
}

@Slf4j
class Until {
	ExpressionBuilder expressionBuilder
	String prefix
	ExpressionPattern pattern
	
	Until(ExpressionBuilder expressionBuilder, ExpressionPattern pattern, String prefix) {
		this.expressionBuilder = expressionBuilder
		this.pattern = pattern
		this.prefix = prefix
	}
	
	ExpressionBuilder until(ExpressionVariable r) {
		expressionBuilder.instance = new PropertyInstance(pattern, "$prefix until $r")
		return expressionBuilder
	}
	
}

@Slf4j
class ExpressionBuilder {
	String p
	ExpressionPattern pattern 
	
	PropertyInstance instance
	
	ExpressionBuilder(ExpressionPattern pattern, ExpressionVariable p) {
		this.p = p
		this.pattern = pattern
	}
	
	PropertyInstance globally() {
		instance = new PropertyInstance(pattern, "$p globally")
	}
	
	PropertyInstance before(ExpressionVariable r) {
		instance = new PropertyInstance(pattern, "$p before $r")
	}
	
	PropertyInstance justAfter(ExpressionVariable q) {
		instance = new PropertyInstance(pattern, "$p justAfter $q")
	}
	
	Until after(ExpressionVariable q) {
		String prefix = "$p after $q"
		return new Until(this, pattern, prefix)
	}
	
	And between(ExpressionVariable q) {
		String prefix = "$p between $q"
		return new And(this, pattern, prefix)
	}
	
	PropertyInstance build() {
		log.debug "expression building"
		instance.build()
	}
}