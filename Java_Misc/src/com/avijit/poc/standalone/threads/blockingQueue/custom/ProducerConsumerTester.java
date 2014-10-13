package com.avijit.poc.standalone.threads.blockingQueue.custom;

public class ProducerConsumerTester {

    public static void main(String[] args) {
        //Creating BlockingQueue of size 10
        CustomBlockingQueue<Message> queue = new CustomBlockingQueue<Message>(10);
       
        Producer producer = new Producer(queue, 5, 200);
        Consumer consumer = new Consumer(queue, 700);
        
        //starting producer to produce messages in queue
        new Thread(producer).start();
        
        //starting consumer to consume messages from queue
        new Thread(consumer).start();
        
        System.out.println("Producer and Consumer has been started");
    }

}
