package com.avijit.poc.standalone.ds.sorts;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] input = { 4, 8, 6, 7, 3, 1, 3, 13, 2, 5, -4 };
		System.out.println(Arrays.toString(input));
		
		quicksort(input, 0, input.length - 1);
		
		System.out.println(Arrays.toString(input));
	}
	
	public static void sort(int[] input, int n) {
		quicksort(input, 0, n - 1);
	}

	private static void quicksort(int[] input, int start, int end) {
		
		int currStart = start;
		int currEnd = end;
		
		// We calculate PIVOT as the mid element, The better the
		// data separated through the pivot the faster will sort work.
		int pivot = input[start + (end - start) / 2];
		//int pivot = input[start];

		while (currStart <= currEnd) {

			while (input[currStart] < pivot) {
				currStart++;
			}

			while (input[currEnd] > pivot) {
				currEnd--;
			}

			if (currStart <= currEnd) {
				
				int temp = input[currStart];
				input[currStart] = input[currEnd];
				input[currEnd] = temp;
				
				currStart++;
				currEnd--;
			}
		}

		if (start < currEnd) {
			quicksort(input, start, currEnd);
		}

		if (currStart < end) {
			quicksort(input, currStart, end);
		}
	}
}
