package com.github.adalrsjr1.specpatterns

import groovy.lang.Closure;
import groovy.util.logging.Slf4j

@Slf4j
class PropertyInstance {
	String property
	ExpressionPattern pattern
	
	PropertyInstance(ExpressionPattern pattern, String property) {
		this.pattern = pattern
		this.property = property
	}
	
	void build() {
		log.debug "property being instantiated"
		println this
	}
	
	String toString() {
		"$pattern:  $property"
	}
}

@Slf4j
class Property {
	static PropertyBuilder create() {
		new PropertyBuilder()
	}
	
}
