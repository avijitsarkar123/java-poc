package com.avijit.poc.standalone.proxy.javaassist;

import java.lang.reflect.Method;
import java.util.Arrays;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

public class CalculatorMethodTracingHandler implements MethodHandler {
	
	public static <T> T createProxy(Class<T> classs) throws Exception {
		
		ProxyFactory factory = new ProxyFactory();
		factory.setSuperclass(classs);
		Object instance = factory.createClass().newInstance();
		((ProxyObject) instance).setHandler(new CalculatorMethodTracingHandler());
		return (T) instance;
	}
	
	@Override
	public Object invoke(Object self, Method overridden, Method forwarder, Object[] args) throws Throwable {
		
		System.out.println("Class: " + self.getClass().getSimpleName() 
				+ " Method: " + overridden.getName() 
				+ " Starts with arguments: " + Arrays.toString(args) );
		
		Object result = forwarder.invoke(self, args);
		
		System.out.println("Class: " + self.getClass().getSimpleName() 
				+ " Method: " + overridden.getName() 
				+ " Ends with result: " + result);
		
		return result;
	}
}
