package com.avijit.poc.standalone.proxy.javaassist;

import com.avijit.poc.standalone.proxy.ArithmeticCalculator;
import com.avijit.poc.standalone.proxy.ArithmeticCalculatorImpl;

public class JavaAssistProxyTester {
	public static void main (String args[]) {

		try {
		
			ArithmeticCalculator arithmeticCalculator = 
						(ArithmeticCalculatorImpl) CalculatorMethodTracingHandler.createProxy(ArithmeticCalculatorImpl.class);
			
			System.out.println(arithmeticCalculator.add(2.0, 3.0));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
