package com.avijit.poc.standalone.ds.arrays;

import java.util.HashMap;
import java.util.Map;

import com.avijit.poc.standalone.ds.sorts.QuickSort;

public class FindDuplicatesInArray {
	public static void main(String[] args) {
		int a[] = {2,4,1,45,76,43,4,79,8,45,1};
		
		//findDuplicatesBySorting(a);
		
		//findDuplicatesUsingMap(a);
		
		int b[] = {1, 2, 3, 1, 3, 6, 6};
		findDuplicatesUsingNegation(b);
	}
	
	// Time Complexity - O(nlogn)
	// Space Complexity - O(1)
	private static void findDuplicatesBySorting(int a[]) {
		
		QuickSort.sort(a, a.length);
		
		for (int i=0; i< a.length-1; i++) {
			if (a[i] == a[i+1]) {
				System.out.println("Duplicate Number: " + a[i]);
			}
		}
	}
	
	// Time Complexity - O(n)
	// Space Complexity - O(n)
	private static void findDuplicatesUsingMap(int a[]) {
		
		Map<Integer, Integer> table = new HashMap<>();
		
		for (int i=0; i<a.length; i++) {
			
			Integer value = table.get(a[i]); 
			
			if (value == null) {
				table.put(a[i], 1);
			} else {
				System.out.println("Duplicate Number: " + a[i]);
				table.put(a[i], value++);
			}
		}
	}
	
	// This is only applicable if we have an array of n numbers in the range of 0 to (n-1)
	// Time Complexity - O(n)
	// Space Complexity - O(1)	
	private static void findDuplicatesUsingNegation(int a[]) {
		
		for (int i=0; i<a.length; i++) {
			
			if (a[Math.abs(a[i])] >= 0) {
				a[Math.abs(a[i])] = -a[Math.abs(a[i])];
			} else {
				System.out.println("Duplicate Number: " + Math.abs(a[i]));
			}
		}
	}
}
