package com.avijit.poc.standalone.ds.sorts;

import java.util.Arrays;

public class HeapSort {
	
	public static void main(String[] args) {
		int[] input = { 4, 8, 6, 7, 3, 1, 3, 13, 2, 5, -4 };
		System.out.println(Arrays.toString(input));
		
		BinaryMinHeap minHeap = new BinaryMinHeap(input.length);
		
		for (int i=0; i<input.length; i++) {
			minHeap.insert(input[i]);
		}
		
		for (int i=0; i<input.length; i++) {
			input[i] = minHeap.extractMinimum();
		}
		
		System.out.println(Arrays.toString(input));
	}
}
