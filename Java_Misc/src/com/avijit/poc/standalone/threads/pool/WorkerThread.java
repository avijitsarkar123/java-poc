package com.avijit.poc.standalone.threads.pool;

import java.util.concurrent.BlockingQueue;

public class WorkerThread extends Thread {
	private boolean isStopped = false;
	private BlockingQueue<Runnable> taskQueue = null;
	
	public WorkerThread(BlockingQueue<Runnable> taskQueue) {
		this.taskQueue = taskQueue;
	}
	
	public void run() {
		while (!isStopped()) {
			try {
				Runnable runnable = taskQueue.take();
				runnable.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void stopWorkerThread() {
	    isStopped = true;
	    this.interrupt(); //break pool thread out of dequeue() call.
	  }

	  public synchronized boolean isStopped() {
	    return isStopped;
	  }
}
