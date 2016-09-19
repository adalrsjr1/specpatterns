package com.github.adalrsjr1.specpatterns

import groovy.util.logging.Slf4j

@Slf4j
class ExpressionVariable {
	String var
	
	ExpressionVariable(String var) {
		this.var = var
	}
	
	boolean evaluate() {
		true
	}
	
	String toString() {
		var
	}
}
