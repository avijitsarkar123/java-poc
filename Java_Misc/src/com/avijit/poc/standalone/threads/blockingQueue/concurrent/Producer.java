package com.avijit.poc.standalone.threads.blockingQueue.concurrent;

import java.util.concurrent.BlockingQueue;


public class Producer implements Runnable {

	int count;
	int delayCount;
    private BlockingQueue<Message> queue;
    
    public Producer(BlockingQueue<Message> queue, int count, int delayCount) {
        this.queue = queue;
        this.count = count;
        this.delayCount = delayCount;
    }
    
    @Override
    public void run() {
        
        for(int i=1; i<=count; i++) {
            Message msg = new Message(""+i);
            try {
                queue.put(msg);
                System.out.println("Produced: " + msg.getMsg());
                Thread.sleep(delayCount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        //adding exit message
        Message msg = new Message("exit");
        
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}