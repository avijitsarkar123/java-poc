package com.avijit.poc.standalone.threads.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExcutorFutureAndCallableExample {
	
	public static void main(String[] args) {
		ExcutorFutureAndCallableExample object = new ExcutorFutureAndCallableExample();
		
		List<String> cardNumberList = new ArrayList<String>();
		cardNumberList.add("1111111111111111");
		cardNumberList.add("2222222222222222");
		cardNumberList.add("3333333333333333");
		
		List<String> tranResponseList = object.getOdsTranDetails(cardNumberList);
		System.out.println(tranResponseList);
	}

	public List<String> getOdsTranDetails(List<String> cardNumbers) {
		
		List<String> tranDetailRequests = new ArrayList<String>();
		
		for (String cardNumber : cardNumbers) {
			tranDetailRequests.add(createTranDetailRequest(cardNumber));
		}
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		List<Future<String>> list = new ArrayList<Future<String>>();
	    for (int i = 1; i <= tranDetailRequests.size(); i++) {
	      Callable<String> worker = new OdsTranDetailResponseCallable("Thread-" + i, i);
	      Future<String> submit = executor.submit(worker);
	      list.add(submit);
	    }
	    
	    System.out.println("ALL REQUESTS SUBMITTED");
	    
	    List<String> tranResponseList = new ArrayList<String>();
	    for (Future<String> future : list) {
	        try {
	          tranResponseList.add(future.get());
	        } catch (InterruptedException e) {
	          e.printStackTrace();
	        } catch (ExecutionException e) {
	          e.printStackTrace();
	        }
	      }
	    
	    executor.shutdown();
	    
	    System.out.println("ALL RESPONSES RECEIVED");
	    
	    return tranResponseList;
		
	}
	
	private String createTranDetailRequest(String cardNumber) {
		String tranDetailRequest = "<ods><tran><request><cardnum>"+cardNumber+"</cardnum></request></tran></ods>";
		return tranDetailRequest;
	}
	
	private class OdsTranDetailResponseCallable implements Callable<String> {
		private int count;
		private String threadName = null;
		
		public OdsTranDetailResponseCallable(String threadName, int count) {	 
	        this.threadName = threadName;
	        this.count = count;
	    }
		
		@Override
		public String call() throws Exception {
			System.out.println(threadName + "- REQUEST RECEIVED");
			String cardNum = threadName + "CardNumber";
			String arn = threadName + "ARN";
			String odsTranDetailResponse = "<ods><tran><response><cardnum>"+cardNum+"</cardnum><arn>"+arn+"</arn></response></tran></ods>";
			Thread.sleep(2000 * count);
			System.out.println(threadName + "- RESPONSE COMPLETED");
			return odsTranDetailResponse;
		}
	}
	
}
