package com.github.adalrsjr1.specpatterns

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		StringBuilder sb = new StringBuilder(pattern.buildTemporalProperty(occurrence))
		int count = 1
		println "size: $variables.size"
		while(variables.size()) {
			ExpressionVariable var = variables.remove(0)
			StringBuffer sbuff = new StringBuffer()
			Pattern p = Pattern.compile("#$count")
			Matcher m = p.matcher(sb.toString())
			
			while(m.find()) {
				m.appendReplacement(sbuff, var.var)
			}
			m.appendTail(sbuff)
			
			sb.setLength(0)
			sb.append(sbuff)
			
			++count
		}
		temporalProperty = sb.toString()
		println ">> $temporalProperty"
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
