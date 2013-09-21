package com.avijit.poc.standalone.proxy.dynamicproxy;

import com.avijit.poc.standalone.proxy.ArithmeticCalculator;
import com.avijit.poc.standalone.proxy.ArithmeticCalculatorImpl;



public class DynamicProxyTester {
	public static void main (String args[]) {
		
		ArithmeticCalculator arithmeticCalculator = 
				(ArithmeticCalculator) CalculatorMethodTracingHandler.createProxy(new ArithmeticCalculatorImpl());
		
		System.out.println(arithmeticCalculator.add(2.0, 3.0));
		
	}
}
