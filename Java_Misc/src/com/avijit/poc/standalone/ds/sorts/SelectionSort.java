package com.avijit.poc.standalone.ds.sorts;

import java.util.Arrays;

/**
 * Array is imaginary divided into two parts - sorted one and unsorted one. 
 * At the beginning, sorted part is empty, while unsorted one contains whole array. 
 * At every step, algorithm finds minimal element in the unsorted part and adds it to the end of the sorted one. 
 * When unsorted part becomes empty, algorithm stops.
 *
 * Here is an example of this sort algorithm sorting five elements:
 * 
 * 64 25 12 22 11
 * 11 64 25 12 22
 * 11 12 64 25 22
 * 11 12 22 64 25
 * 11 12 22 25 64
 * 
 * Space complexity - It is inplace with use of very few constants.
 * Thus -> In Place. O(1)
 * Data structure	- Array
 * Worst case performance - О(n2) // (even when list is descendingly sorted, it has to find min looking through all)
 * Best case performance - О(n2) // (even when list is ascendingly sorted, it has to find min looking through all)
 * Average case performance - О(n2) // because it has to find min looking through all.
 * 
 * @author avijit
 */

public class SelectionSort {
	public static void main(String[] args) {
		
		int[] input = { 4, 8, 6, 7, 3, 1, 3, 13, 2, 5, -4 };
		System.out.println(Arrays.toString(input));
		
		selectionSort(input);
		
		System.out.println(Arrays.toString(input));
		
	}
	
	private static int[] selectionSort(int a[]) {
		int minIndex = 0;
		
		for (int i=0; i<a.length; i++) {
			minIndex = i;
			
			for (int j=i+1; j<a.length; j++) {
				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
			}
			
			if (i != minIndex) {
				int temp = a[minIndex];
				a[minIndex] = a[i];
				a[i] = temp;
			}
		}
		
		return a;
	}
}
