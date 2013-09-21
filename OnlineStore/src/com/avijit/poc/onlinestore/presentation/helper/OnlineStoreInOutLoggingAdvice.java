package com.avijit.poc.onlinestore.presentation.helper;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class OnlineStoreInOutLoggingAdvice implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Entering Class :: " + invocation.getMethod().getClass().getName() + " Method :: " + invocation.getMethod().getName());
		Object retValue = invocation.proceed();
		System.out.println("Exiting Class :: " + invocation.getMethod().getClass().getName() + " Method :: " + invocation.getMethod().getName());
		return retValue;
	}

}
