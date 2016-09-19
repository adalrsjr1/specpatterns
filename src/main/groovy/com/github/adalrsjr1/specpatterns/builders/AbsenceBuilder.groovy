package com.github.adalrsjr1.specpatterns.builders

import com.github.adalrsjr1.specpatterns.ExpressionPattern;
import com.github.adalrsjr1.specpatterns.ExpressionVariable;
import com.github.adalrsjr1.specpatterns.TemporalOccurrence

import groovy.util.logging.Slf4j

@Slf4j
class AbsenceBuilder {
	private static final Map<TemporalOccurrence, String> temporalProperties = [
		(TemporalOccurrence.GLOBALLY) : "G(!#)",
		(TemporalOccurrence.BEFORE_R) : "F# -> (!# U #)",
		(TemporalOccurrence.AFTER_Q) : "G(# -> G(!#))",
		(TemporalOccurrence.BETWEEN_Q_AND_R) : "G((# && !# & F#) -> (!# U #))",
		(TemporalOccurrence.AFTER_Q_UNTIL_R) : "G(# && !# -> (!# W #))",
		]
	
	static String getTemporalProperty(TemporalOccurrence occurrence) {
		temporalProperties[occurrence]
	}
}
