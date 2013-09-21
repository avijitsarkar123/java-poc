package com.avijit.poc.standalone.proxy.cglib;

import com.avijit.poc.standalone.proxy.ArithmeticCalculator;
import com.avijit.poc.standalone.proxy.ArithmeticCalculatorImpl;

public class CGLibProxyTester {
	public static void main (String args[]) {

		try {
		
			ArithmeticCalculator arithmeticCalculator = 
						(ArithmeticCalculator) CalculatorMethodTracingHandler.createProxy(new ArithmeticCalculatorImpl());
			
			System.out.println(arithmeticCalculator.add(2.0, 3.0));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
