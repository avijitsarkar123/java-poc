package com.avijit.poc.standalone.ds.arrays;

/*
 * 
 * An array contains n numbers ranging from 0 to n-2. 
 * There is exactly one number duplicated in the array. 
 * How do you find the duplicated number? 
 * For example, if an array with length 5 contains numbers {1, 2, 3, 3, 4}, the duplicated number is 3.
 * 
 */

public class FindDuplicateInArray {
	
	public static void main (String[] args) {
		int[] a = {1,2,3,3,4};
		System.out.print(findDuplicate(a));
	}
	
	public static int findDuplicate(int[] a) {
		
		int sumOfAllNumbersInArray = 0;
		
		// This sum included all the numbers between 1+2+3+...+(n-1) + DUPLICATE
		for (int i=0; i<a.length; i++) {
			sumOfAllNumbersInArray += a[i];
		}
		
		// Find the sum of numbers: 1+2+3+....+(n-1)
		int sumOfAllNumbersInRange = ((a.length) * (a.length - 1))/2;
		
		return sumOfAllNumbersInArray - sumOfAllNumbersInRange;
	}
	
}
