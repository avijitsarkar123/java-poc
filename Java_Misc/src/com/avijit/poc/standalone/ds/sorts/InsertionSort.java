package com.avijit.poc.standalone.ds.sorts;

import java.util.Arrays;

/**
 * Insertion sort algorithm somewhat resembles selection sort. 
 * Array is imaginary divided into two parts - sorted one and unsorted one. 
 * At the beginning, sorted part contains first element of the array and unsorted one contains the rest. 
 * At every step, algorithm takes first element in the unsorted part and inserts it to the right place of the sorted one. 
 * When unsorted part becomes empty, algorithm stops.
 * 
 * This is how we sort a pack of in hand cards.
 * 
 * Space complexity - It is inplace with use of very few constants.
 * Thus -> In Place. O(1)
 * Best Case = O(n) // occurs when the list is already sorted ascending - it picks up the next element and just inserts into the last spot of sorted array.
 * Worst case = O(n^2) // occurs when the list is already sorted descending - when it picks up the new element, it has to loop through entire sorted array and place the element at 1st place
 * Average Case - O(n^2) // although the average-case running time is approximately half of the worst-case running time, it is still a quadratic function of n.
 * 
 * @author avijit
 *
 */

public class InsertionSort {
	public static void main(String[] args) {
		
		int[] input = { 4, 8, 6, 7, 3, 1, 3, 13, 2, 5, -4 };
		System.out.println(Arrays.toString(input));
		
		insertionSort(input);
		
		System.out.println(Arrays.toString(input));
		
	}
	
	private static int[] insertionSort(int a[]) {
		
		for (int i=1; i<a.length; i++) {
			
			for (int j=i; j > 0; j--) {
				
				if (a[j-1] > a[j]) {
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
		
		return a;
	}
}
