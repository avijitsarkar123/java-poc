package com.avijit.poc.standalone.ds.sorts;


public class BinaryMinHeap {
	private int[] data;
	private int heapSize;
	
	public BinaryMinHeap(int size) {
		this.data = new int[size];
		heapSize = 0;
	}
	
	private int getParentNodeIndex(int nodeIndex) {
		return (int) (nodeIndex-1)/2;
	}
	
	private int getLeftChildIndex(int nodeIndex) {
		return 2*nodeIndex + 1;
	}
	
	private int getRightChildIndex(int nodeIndex) {
		return 2*nodeIndex + 2;
	}
	
	public void insert(int value) {
		if (heapSize == data.length) {
			throw new RuntimeException("HEAP OVERFLOW");
		}
		
		heapSize++;
		data[heapSize-1] = value;
		
		heapifyUp(heapSize-1);
	}
	
	private void heapifyUp(int nodeIndex) {
		
		int parentNodeIndex = getParentNodeIndex(nodeIndex);
		
		if (data[nodeIndex] > data[parentNodeIndex] || nodeIndex == 0) {
			return;
		}
		
		if (data[nodeIndex] < data[parentNodeIndex]) {
			
			// Swap with the parent node
			int temp = data[parentNodeIndex];
			data[parentNodeIndex] = data[nodeIndex];
			data[nodeIndex] = temp;
						
			// Now set the currentIndex to parentNodeIndex
			nodeIndex = parentNodeIndex;
			heapifyUp(nodeIndex);
		}
	}
	
	public int extractMinimum() {
		if (heapSize == 0) {
			throw new RuntimeException("HEAP EMPTY");
		}
		
		int returnValue = data[0];
		data[0] = data[heapSize-1];
		heapSize--;
		
		if (heapSize > 0) {
			heapifyDown(0);
		}
		
		return returnValue;
	}
	
	private void heapifyDown(int nodeIndex) {
		
		int smallChildIndex = -1;
		int leftChildNodeIndex = getLeftChildIndex(nodeIndex);
		int rightChildNodeIndex = getRightChildIndex(nodeIndex);
		
		// If no children then we are done
		if (leftChildNodeIndex > heapSize && rightChildNodeIndex > heapSize) {
			return;
		}
		
		if (leftChildNodeIndex < heapSize && rightChildNodeIndex < heapSize) {
			smallChildIndex = data[leftChildNodeIndex] - data[rightChildNodeIndex] < 0 ? leftChildNodeIndex : rightChildNodeIndex;
		} else if (leftChildNodeIndex < heapSize) {
			smallChildIndex = leftChildNodeIndex;
		} else {
			smallChildIndex = rightChildNodeIndex;
		}
		
		if (smallChildIndex >= 0 && data[nodeIndex] > data[smallChildIndex]) {
			
			int temp = data[nodeIndex];
			data[nodeIndex] = data[smallChildIndex];
			data[smallChildIndex] = temp;
			
			heapifyDown(smallChildIndex);
		}
	}
	
	public void print() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for (int i=0; i<heapSize; i++) {
			builder.append(data[i]).append(", ");
		}
		System.out.println(builder.append("]").toString());
	}
	
	public static void main(String[] args) {
		
		int[] input = {16,7,12,21,5,9,11};
		
		BinaryMinHeap minHeap = new BinaryMinHeap(input.length);
		
		for (int value : input) {
			minHeap.insert(value);
		}
		
		minHeap.print();
		
		System.out.println(minHeap.extractMinimum());
		minHeap.print();
		
		System.out.println(minHeap.extractMinimum());
		minHeap.print();
	}
	
}
