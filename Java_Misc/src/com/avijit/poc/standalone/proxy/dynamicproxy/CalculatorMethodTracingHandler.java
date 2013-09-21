package com.avijit.poc.standalone.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import com.avijit.poc.standalone.proxy.ArithmeticCalculator;


public class CalculatorMethodTracingHandler implements  InvocationHandler {

	private Object target;
	
	public CalculatorMethodTracingHandler(Object target) {
		super();
		this.target = target;
	}
	
	public static Object createProxy(Object target) {
		return (ArithmeticCalculator) Proxy.newProxyInstance(
												target.getClass().getClassLoader(), 
												target.getClass().getInterfaces(), 
												new CalculatorMethodTracingHandler(target));
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("Class: " + proxy.getClass().getSimpleName() 
							+ " Method: " + method.getName() 
							+ " Starts with arguments: " + Arrays.toString(args) );
		
		Object result = method.invoke(target, args);
		
		System.out.println("Class: " + proxy.getClass().getSimpleName() 
				+ " Method: " + method.getName() 
				+ " Ends with result: " + result);
		
		return result;
	}

}
