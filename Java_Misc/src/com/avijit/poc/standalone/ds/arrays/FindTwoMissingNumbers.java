package com.avijit.poc.standalone.ds.arrays;

public class FindTwoMissingNumbers {
	public static void main(String[] args) {
		//int[] a = {2,5,6,1,9,4,7};

		int index = 0;
		int[] a = {1,2,4,6,7,8,9};
		
		index = 0;
		for (int i=1; i<=a.length; i++) {

			
			//System.out.println("a[index] = " + a[index] + " i = " + i + " a[i] ^ i = " + (a[index] ^ i));
			
			if (!((a[index] ^ (i)) == 0)) {
				System.out.println(i);
				i--;
			} else {
				index++;
			}
		}
	}
}
