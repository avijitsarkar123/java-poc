package com.avijit.poc.onlinestore.business.exception;

public class UnsupportedException extends RuntimeException{
	public UnsupportedException() {
		super("The operation is not supported by this instance");
	}
}
