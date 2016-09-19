package com.github.adalrsjr1.specpatterns


import groovy.util.logging.Slf4j

@Slf4j
public class App 
{
    public static void main( String[] args )
    {
		ExpressionVariable p = new ExpressionVariable("P")
		ExpressionVariable q = new ExpressionVariable("Q")
		ExpressionVariable r = new ExpressionVariable("R")
		ExpressionVariable s = new ExpressionVariable("S")
		ExpressionVariable t = new ExpressionVariable("T")
		ExpressionVariable z = new ExpressionVariable("Z")
		
		PropertyPattern pp = Property.create()
		
		pp.absence(p)
			.isFalse()
			.between(q)
			.and(r)
			.build()
			
		pp.absence(p)
			.isFalse()
			.before(r)
			.build()
			
		pp.existence(p)
			.becomesTrue()
			.globally()
			.build()
			
		pp.universality(p)
			.isTrue()
			.after(q)
			.until(r)
			.build()
			
		pp.precedence(s)
			.precedes(p)
			.between(q)
			.and(r)
			.build()
			
		pp.response(s)
			.respondsTo(p)
			.globally()
			.build()
			
		pp.boundedExistence(p)
			.occurs(3)
			.globally()
			.build()
			
		pp.precedenceChain(s,t)
			.precedes(p)
			.globally()
			.build()
			
		pp.precedenceChain(p)
			.precedes(s,t)
			.globally()
			.build()
		
		pp.responseChain(s, t)
			.respondsTo(p)
			.between(q)
			.and(r)
			.build()
			
		pp.responseChain(p)
			.respondsTo(s,t)
			.globally()
			.build()
			
		pp.constrainedChain(s,t)
			.without(z)
		  	.respondsTo(p)
			.after(q)
			.until(r)
			.build()
			
    }
}
