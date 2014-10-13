package com.avijit.poc.standalone.threads.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
	private boolean isStopped = false;
	private BlockingQueue<Runnable> taskQueue = null;
	private List<WorkerThread> workerThreads = new ArrayList<WorkerThread>();
	
	public ThreadPool(int numOfThreads, int maxNumTasks) {
		this.taskQueue = new ArrayBlockingQueue<>(maxNumTasks);
		
		for(int i=0; i<numOfThreads; i++){
			workerThreads.add(new WorkerThread(taskQueue));
	    }
	    
		for(WorkerThread workerThread : workerThreads){
			workerThread.start();
	    }
	}
	
	public synchronized void execute(Runnable task) {
		
		if(this.isStopped) {
			throw new IllegalStateException("ThreadPool is stopped");
		}
	    	
		try {
			this.taskQueue.put(task);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void stop(){
	    this.isStopped = true;
	    
	    for(WorkerThread workerThread : workerThreads){
	    	workerThread.stopWorkerThread();
	    }
	}
}
