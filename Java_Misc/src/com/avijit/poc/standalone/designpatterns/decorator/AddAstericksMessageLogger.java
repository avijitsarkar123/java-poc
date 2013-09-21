package com.avijit.poc.standalone.designpatterns.decorator;

public class AddAstericksMessageLogger implements Logger {

	private Logger logger;
	
	public AddAstericksMessageLogger(Logger logger) {
		this.logger = logger;
	}
	
	@Override
	public void logMessage(String message) {
		String modifiedMessage = "*** " + message.toLowerCase() + " ***";
		logger.logMessage(modifiedMessage);
	}

}
