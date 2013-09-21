package com.avijit.poc.standalone.ds.sorts;

import java.util.Arrays;

public class MergeSort {
	
	private static int inputCopy[];
	private static int input[] = { 10, 6, 4, 2, 8, 0, 14, 12 };

	public static void main(String[] args) {
		System.out.println("INPUT Unsorted : " + Arrays.toString(input));
		inputCopy = new int[input.length];
	
		mergeSort(0, input.length - 1);
		
		System.out.println("OUTPUT Sorted  : " + Arrays.toString(input));
	}

	private static void mergeSort(int start, int end) {
		
		int mid = start + (end - start) / 2;
		
		if (start < end) {
			// DIVIDE: Split from start to mid
			mergeSort(start, mid);
			
			// DIVIDE: Split from mid + 1 to end
			mergeSort(mid + 1, end);
			
			// CONQUER: Sort & Merge the two arrays
			merge(start, mid, end);
		}
	}

	private static void merge(int start, int mid, int end) {
		/**
		 * So we have 2 arrays to be SORTED and MERGED. To go through every
		 * element we need to find the start of each array.
		 */
		int firstArrStart = start; 
		int secondArrStart = mid + 1;
		
		/**
		 * We create a copy of the area that we want to work on as We will be
		 * modifying it as we read it and we need to make decisions on the data
		 * before modification
		 */
		for (int i = start; i <= end; i++) {
			inputCopy[i] = input[i];
		}
		
		while (secondArrStart <= end && firstArrStart <= mid) {

			// If the 1st element of left array is greater than 1st element of right array then add the 1st element of right array in the final array
			if (inputCopy[firstArrStart] >= inputCopy[secondArrStart])
				input[start++] = inputCopy[secondArrStart++];
			else
				input[start++] = inputCopy[firstArrStart++];
		}

		// Any left over from the left array - copy into the final array
		while (firstArrStart <= mid) {
			input[start++] = inputCopy[firstArrStart++];
		}

		// Any left over from the right array - copy into the final array
		while (secondArrStart <= end) {
			input[start++] = inputCopy[secondArrStart++];
		}
	}
}
