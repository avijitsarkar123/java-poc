package com.avijit.poc.standalone.threads.misc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

	public static void main(String[] args) {
		
		ExecutorService execService = createExecutorService(2);
		
/*		System.out.println("***** CACHED THREAD POOL *****");
		execService.execute(new TestTask("FirstTestTask"));
		execService.execute(new TestTask("SecondTestTask"));
		execService.execute(new TestTask("ThirdTestTask"));
*/		
/*		System.out.println("***** FIXED THREAD POOL *****");
		execService.execute(new TestTask("FirstTestTask"));
		execService.execute(new TestTask("SecondTestTask"));
		execService.execute(new TestTask("ThirdTestTask"));
		execService.execute(new TestTask("FourthTestTask"));*/
		

		execService.execute(new Task("FirstTestTask"));
		execService.execute(new Task("SecondTestTask"));
		execService.execute(new Task("ThirdTestTask"));
		execService.execute(new Task("ForthTestTask"));

		System.out.println("ALL TASKS SCHEDULED TO RUN BY EXECUTOR SERVICE");
		
		execService.shutdown();
	}
	
	private static ExecutorService createExecutorService(int type) {
		switch (type) {
			case 1:
				return Executors.newCachedThreadPool();
			case 2:
				return Executors.newFixedThreadPool(2);
			case 3:
				return Executors.newSingleThreadExecutor();
		}
		
		return null;
	}
	
	private static class Task implements Runnable {

		private String taskName;

		public Task(String taskName) {
			this.taskName = taskName;
		}
		
		public void run() {
			try {
				System.out.println(this.taskName + " is sleeping...");
				Thread.sleep(3000);
				System.out.println(this.taskName + " is running...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
