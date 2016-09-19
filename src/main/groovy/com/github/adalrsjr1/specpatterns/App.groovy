package com.github.adalrsjr1.specpatterns


import groovy.util.logging.Slf4j

@Slf4j
public class App 
{
    public static void main( String[] args )
    {
		ExpressionVariable p = new ExpressionVariable("p")
		ExpressionVariable q = new ExpressionVariable("q")
		ExpressionVariable r = new ExpressionVariable("r")
		ExpressionVariable s = new ExpressionVariable("s")
		ExpressionVariable t = new ExpressionVariable("t")
		ExpressionVariable z = new ExpressionVariable("z")
		
		PropertyPattern pp = Property.create()
		
		println pp.absence(p)
		.isFalse()
		.before(r)
		.build()
		
		println pp.absence(p)
			.isFalse()
			.between(q)
			.and(r)
			.build()
			
		println pp.existence(p)
			.becomesTrue()
			.globally()
			.build()
			
		println pp.universality(p)
			.isTrue()
			.after(q)
			.until(r)
			.build()
			
		println pp.precedence(s)
			.precedes(p)
			.between(q)
			.and(r)
			.build()
			
		println pp.response(s)
			.respondsTo(p)
			.globally()
			.build()
			
		println pp.boundedExistence(p)
			.occurs(3)
			.globally()
			.build()
			
		println pp.precedenceChain(s,t)
			.precedes(p)
			.globally()
			.build()
			
		println pp.precedenceChain(p)
			.precedes(s,t)
			.globally()
			.build()
		
		println pp.responseChain(s, t)
			.respondsTo(p)
			.between(q)
			.and(r)
			.build()
			
		println pp.responseChain(p)
			.respondsTo(s,t)
			.globally()
			.build()
			
		println pp.constrainedChain(s,t)
			.without(z)
		  	.respondsTo(p)
			.after(q)
			.until(r)
			.build()
			
    }
}
