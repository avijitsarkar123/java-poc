package com.avijit.poc.standalone.ds.arrays;

// Given an array of random numbers, Push all the zero’s of a given array to the end of the array. 
// For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, 
// it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. The order of all other elements should be same. 
// Expected time complexity is O(n) and extra space is O(1).

public class PushZerosToEnd {
	
	public static void main (String[] args) {
		int a[] = {0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
		printArray(a);
		
		pushZerosToEnd(a);
		
		printArray(a);
	}
	
	/* Traverse the given array ‘arr’ from left to right. 
	 * While traversing, maintain count of non-zero elements in array. Let the count be ‘count’. 
	 * For every non-zero element arr[i], put the element at ‘arr[count]‘ and increment ‘count’. 
	 * After complete traversal, all non-zero elements have already been shifted to front end 
	 * and ‘count’ is set as index of first 0. Now all we need to do is that run a loop which makes 
	 * all elements zero from ‘count’ till end of the array.
	 */
	private static void pushZerosToEnd(int a[]) {
		
		int counter = 0;
		for (int i=0; i<a.length; i++) {
			if (a[i] != 0) {
				a[counter++] = a[i];
			}
		}
		
		for (int i=counter; i<a.length; i++) {
			a[i] = 0;
		}
	}
	
	private static void printArray(int[] a) {
		System.out.println("");
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i]);
		}
	}
}
