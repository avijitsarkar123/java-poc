package com.avijit.poc.standalone.ds.sorts;

public class BinarySearch {
	public static void main(String[] args) {
		
		int[] a = {11,21,31,41,51,61,71,81,91};
		int index = binarySearchRecursive(a, 31);
		
		if (index > -1) {
			System.out.println(a[index] + " FOUND AT INDEX: " + index);
		} else {
			System.out.println("NOT FOUND");
		}
	}
	
	private static int binarySearchIterative(int[] a, int key) {
		int start = 0;
		int end = a.length-1;
		
		while (start <= end) {
			int mid = start + (end-start)/2;
			if (a[mid] == key) {
				return mid;
			} else if (a[mid] < key) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		
		return -1;
	}
	
	private static int binarySearchRecursive(int[] a, int key) {
		return binarySearch(a, key, 0, a.length-1);
	}
	
	private static int binarySearch(int[] a, int key, int start, int end) {
		
		if (start > end) 
			return -1; 
		
		int mid = start + (end-start)/2;
		
		if (a[mid] == key) {
			return mid;
		} else if (a[mid] < key) {
			return binarySearch(a, key, mid+1, end);
		} else {
			return binarySearch(a, key, start, mid-1);
		}
		
	}
}
