package com.github.adalrsjr1.specpatterns

import groovy.util.logging.Slf4j

@Slf4j
class PropertyInstance {
	List<ExpressionVariable> variables
	ExpressionPattern pattern
	TemporalOccurrence occurrence

	String temporalProperty

	PropertyInstance(TemporalOccurrence occurrence, ExpressionPattern pattern, List<ExpressionVariable> variables) {
		this.occurrence = occurrence
		this.pattern = pattern
		this.variables = variables
	}

	void build() {
		temporalProperty = pattern.buildTemporalProperty(occurrence)
		// still need substitute #i to correct var 
	}

	String toString() {
		if(temporalProperty == null || temporalProperty == "") "property still not builded"
		else temporalProperty
	}
}

@Slf4j
class Property {
	static PropertyPattern create() {
		new PropertyPattern()
	}

}
