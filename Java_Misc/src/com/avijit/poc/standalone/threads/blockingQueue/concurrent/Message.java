package com.avijit.poc.standalone.threads.blockingQueue.concurrent;

public class Message {
	
	private final String msg;
    
    public Message(String str) {
        this.msg=str;
    }

    public String getMsg() {
        return msg;
    }
}