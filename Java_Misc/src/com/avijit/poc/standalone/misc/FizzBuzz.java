package com.avijit.poc.standalone.misc;

public class FizzBuzz {
	
	public static void main (String[] args) {
		long startTime = System.currentTimeMillis();
		approach1();
		long endTime = System.currentTimeMillis();
		long approach1 = endTime - startTime;
		
		startTime = System.currentTimeMillis();
		approach2();
		endTime = System.currentTimeMillis();
		long approach2 = endTime - startTime;
		
		System.out.println(approach1);
		System.out.println(approach2);
	}
	
	public static void approach1() {
		
		for (int i=1; i<=1000; i++) {
			
			if (i%15 == 0) {
				System.out.println("FIZZBUZZ");
			}
			else if (i%3 == 0) {
				System.out.println("FIZZ");
			}
			else if (i%5 == 0) {
				System.out.println("BUZZ");
			}
		}
		
	}
	
	public static void approach2() {
		
		StringBuffer str = new StringBuffer();
		for (int i=1; i<=1000; i++) {
			
			boolean multipleOfThree = (i%3 == 0);
			boolean multipleOfFive = (i%5 == 0);
			
			if (multipleOfThree && multipleOfFive) {
				str.append("FIZZBUZZ \n");
			}
			else if (multipleOfThree) {
				str.append("FIZZ \n");
			}
			else if (multipleOfFive) {
				str.append("BUZZ \n");
			}
		}
		
		System.out.println(str.toString());
		
	}
}
