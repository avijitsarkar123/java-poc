package com.avijit.poc.standalone.threads.blockingQueue.custom;

public class Consumer implements Runnable{

	private int delayCount;
    private CustomBlockingQueue<Message> queue;
    
    public Consumer(CustomBlockingQueue<Message> queue, int delayCount) {
        this.queue = queue;
        this.delayCount = delayCount;
    }

    @Override
    public void run() {
        try {
            Message msg;
            while((msg = queue.dequeue()).getMsg() != "exit") {
	            Thread.sleep(delayCount);
	            System.out.println("Consumed " + msg.getMsg());
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}