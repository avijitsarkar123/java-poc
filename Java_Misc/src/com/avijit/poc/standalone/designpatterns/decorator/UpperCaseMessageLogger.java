package com.avijit.poc.standalone.designpatterns.decorator;

public class UpperCaseMessageLogger implements Logger {

	private Logger logger;
	
	public UpperCaseMessageLogger(Logger logger) {
		this.logger = logger;
	}
	
	@Override
	public void logMessage(String message) {
		String upperCaseMessage = message.toUpperCase();
		logger.logMessage(upperCaseMessage);
	}

}
