package com.avijit.poc.standalone.threads.blockingQueue.concurrent;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

	private int delayCount;
    private BlockingQueue<Message> queue;
    
    public Consumer(BlockingQueue<Message> queue, int delayCount) {
        this.queue = queue;
        this.delayCount = delayCount;
    }

    @Override
    public void run() {
        try {
            Message msg;
            while((msg = queue.take()).getMsg() != "exit") {
	            Thread.sleep(delayCount);
	            System.out.println("Consumed " + msg.getMsg());
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}