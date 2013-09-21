package com.avijit.poc.standalone.designpatterns.decorator;

public class Client {
	
	// The Decorator Pattern attaches additional responsibilities to an object dynamically.
	// Decorators provide a flexible alternative to subclassing for extending functionality.
	
	public static void main(String args[]) {
		
		String message = "abcd EFGH ijkl";
		
		// Regular Logger
		Logger logger = new MessageLogger();
		logger.logMessage(message);
		
		// Upper Case Logger
		logger = new UpperCaseMessageLogger(new MessageLogger());
		logger.logMessage(message);
		
		// Add Astericks Logger
		logger = new AddAstericksMessageLogger(new MessageLogger());
		logger.logMessage(message);
		
		// Add Astericks Upper Case Logger
		logger = new AddAstericksMessageLogger(new UpperCaseMessageLogger(new MessageLogger()));
		logger.logMessage(message);
		
	}
}
