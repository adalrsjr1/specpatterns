package com.github.adalrsjr1.specpatterns

import java.util.Map;

enum ExpressionPattern {
	ABSENCE {
		String buildTemporalProperty(TemporalOccurrence temporalProperty) {
			switch(temporalProperty) {
				case TemporalOccurrence.GLOBALLY : return "G(!#1)"
				case TemporalOccurrence.BEFORE_R : return "F#2 -> (!#1 U #2)"
				case TemporalOccurrence.AFTER_Q : return "G(#2 -> G(!#1))"
				case TemporalOccurrence.BETWEEN_Q_AND_R : return "G((#2 && !#3 & F#3) -> (!#1 U #3))"
				case TemporalOccurrence.AFTER_Q_UNTIL_R : return "G(#2 && !#3 -> (!#1 W #3))"
				default: return ""
			}
		}
	}, 
	EXISTENCE {
		String buildTemporalProperty(TemporalOccurrence temporalProperty) {
			switch(temporalProperty) {
				case TemporalOccurrence.GLOBALLY : return "F(#1)"
				case TemporalOccurrence.BEFORE_R : return "!#2 W (#1 && !#2)"
				case TemporalOccurrence.AFTER_Q : return "G(!#2) | F(#2 & F#1))"
				case TemporalOccurrence.BETWEEN_Q_AND_R : return "G(#2 & !#3 -> (!#3 W (#1 && !#3)))"
				case TemporalOccurrence.AFTER_Q_UNTIL_R : return "G(#2 & !#3 -> (!#3 U (#1 && !#3)))"
				default: return ""
			}
		}
	},
	BOUNDED_EXISTENCE {
		String buildTemporalProperty(TemporalOccurrence temporalProperty) {
			
		}
	},
	UNIVERSALITY {
		String buildTemporalProperty(TemporalOccurrence temporalProperty) {
			
		}
	},
	PRECEDENCE {
		String buildTemporalProperty(TemporalOccurrence temporalProperty) {
			
		}
	},
	RESPONSE {
		String buildTemporalProperty(TemporalOccurrence temporalProperty) {
			
		}
	},
	PRECEDENCE_CHAIN_ONE {
		String buildTemporalProperty(TemporalOccurrence temporalProperty) {
			
		}
	},
	PRECEDENCE_CHAIN_TWO {
		String buildTemporalProperty(TemporalOccurrence temporalProperty) {
			
		}
	},
	RESPONSE_CHAIN_ONE {
		String buildTemporalProperty(TemporalOccurrence temporalProperty) {
			
		}
	},
	RESPONSE_CHAIN_TWO {
		String buildTemporalProperty(TemporalOccurrence temporalProperty) {
			
		}
	},
	CONSTRAINED_CHAIN {
		String buildTemporalProperty(TemporalOccurrence temporalProperty) {
			
		}
	}
	
	abstract String buildTemporalProperty(TemporalOccurrence temporalProperty);
}
