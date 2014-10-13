package com.avijit.poc.standalone.threads.pool;

public class ThreadPoolTester {
	public static void main (String[] args) {
		
		ThreadPool threadPool = new ThreadPool(3, 10);
		
		for (int i=1 ; i<=10; i++) {
			threadPool.execute(createTestThread(i));
		}
		
	}
	
	public static Thread createTestThread(final int count) {
		
		return  new Thread () {
			
			@Override
			public void run() {
				try {
					sleep(1000 * count);
					System.out.println("Worker Thread " + count + " : Working");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
	}
}
