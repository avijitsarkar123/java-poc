package com.avijit.poc.standalone.proxy.cglib;

import java.lang.reflect.Method;
import java.util.Arrays;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CalculatorMethodTracingHandler implements MethodInterceptor {
   private Object target;
   
   public CalculatorMethodTracingHandler(Object target) {
       this.target = target;
   }
   
   public static <T> T createProxy(T target) {
       Enhancer enhancer = new Enhancer();

       enhancer.setSuperclass(target.getClass());
       
       enhancer.setCallback(new CalculatorMethodTracingHandler(target));

       T proxifiedTarget = (T) enhancer.create();
       
       return proxifiedTarget;
   }
   
   public Object intercept(Object self, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
	   
	   System.out.println("Class: " + self.getClass().getSimpleName() 
				+ " Method: " + method.getName() 
				+ " Starts with arguments: " + Arrays.toString(args) ); 
       
       Object result = method.invoke(target, args);
       
       System.out.println("Class: " + self.getClass().getSimpleName() 
				+ " Method: " + method.getName() 
				+ " Ends with result: " + result);
       
       return result;
   }    
} 

