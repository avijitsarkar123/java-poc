package com.avijit.poc.standalone.ds.arrays;

public class FindMissingNumberInRangeArray {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,7,8,9};
		System.out.println(findMissingNumberInArray(a));
	}
	
	// The missing number is the sum of all the numbers in the range minus the sum of 
	// all the numbers in the array 
	public static int findMissingNumberInArray(int a[]) {
		int sum = 0;
		for (int i=0; i<a.length; i++) {
			sum+= a[i];
		}
		
		int numberRange = a.length+1;
		return ((numberRange * (numberRange+1))/2) - sum;
	}
}

