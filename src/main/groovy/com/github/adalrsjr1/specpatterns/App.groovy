package com.github.adalrsjr1.specpatterns


import groovy.util.logging.Slf4j

@Slf4j
public class App 
{
    public static void main( String[] args )
    {
		PropertyBuilder pp = Property.create()
		pp.absence(new ExpressionVariable("P"))
			.between(new ExpressionVariable("P"))
			.and(new ExpressionVariable("P"))
		pp.boundedExistence(new ExpressionVariable("P"))
			.after(new ExpressionVariable("Q"))
			.until(new ExpressionVariable("R"))
		pp.response(new ExpressionVariable("P"))
		pp.build()
    }
}
