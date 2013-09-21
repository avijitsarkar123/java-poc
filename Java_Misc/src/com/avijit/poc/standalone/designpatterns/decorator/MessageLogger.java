package com.avijit.poc.standalone.designpatterns.decorator;

public class MessageLogger implements Logger {

	@Override
	public void logMessage(String message) {
		System.out.println("LOGGING MESSAGE: " + message);
	}

}
