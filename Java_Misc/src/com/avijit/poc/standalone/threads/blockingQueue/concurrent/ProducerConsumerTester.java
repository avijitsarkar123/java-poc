package com.avijit.poc.standalone.threads.blockingQueue.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerTester {

    public static void main(String[] args) {
        //Creating BlockingQueue of size 10
        BlockingQueue<Message> queue = new ArrayBlockingQueue<Message>(5);
       
        Producer producer = new Producer(queue, 10, 100);
        Consumer consumer = new Consumer(queue, 400);
        
        //starting producer to produce messages in queue
        new Thread(producer).start();
        
        //starting consumer to consume messages from queue
        new Thread(consumer).start();
        
        System.out.println("Producer and Consumer has been started");
    }

}
