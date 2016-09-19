package com.github.adalrsjr1.specpatterns

import com.github.adalrsjr1.specpatterns.builders.AbsenceBuilder;

import groovy.lang.Closure;
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
		log.debug "property being instantiated"

		switch(pattern) {
			case ExpressionPattern.ABSENCE: println AbsenceBuilder.getTemporalProperty(occurrence)
				break
			case ExpressionPattern.EXISTENCE: println AbsenceBuilder.getTemporalProperty(occurrence)
				break
			case ExpressionPattern.BOUNDED_EXISTENCE: println AbsenceBuilder.getTemporalProperty(occurrence)
				break
			case ExpressionPattern.UNIVERSALITY: println AbsenceBuilder.getTemporalProperty(occurrence)
				break
			case ExpressionPattern.PRECEDENCE: println AbsenceBuilder.getTemporalProperty(occurrence)
				break
			case ExpressionPattern.RESPONSE: println AbsenceBuilder.getTemporalProperty(occurrence)
				break
			case ExpressionPattern.PRECEDENCE_CHAIN_ONE: println AbsenceBuilder.getTemporalProperty(occurrence)
				break
			case ExpressionPattern.PRECEDENCE_CHAIN_TWO: println AbsenceBuilder.getTemporalProperty(occurrence)
				break
			case ExpressionPattern.RESPONSE_CHAIN_ONE: println AbsenceBuilder.getTemporalProperty(occurrence)
				break
			case ExpressionPattern.RESPONSE_CHAIN_TWO: println AbsenceBuilder.getTemporalProperty(occurrence)
				break
			case ExpressionPattern.CONSTRAINED_CHAIN: println AbsenceBuilder.getTemporalProperty(occurrence)
				break
		}

	}

	String toString() {
		if(temporalProperty == null) "property still not builded"
		else temporalProperty
	}
}

@Slf4j
class Property {
	static PropertyPattern create() {
		new PropertyPattern()
	}

}
