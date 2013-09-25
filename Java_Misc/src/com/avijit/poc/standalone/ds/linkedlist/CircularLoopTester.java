package com.avijit.poc.standalone.ds.linkedlist;

public class CircularLoopTester {
	
	public static void main(String[] args) {
		
		createCircularLoopLinkedList();
		
	}
	
	private static void createCircularLoopLinkedList() {
		
		ListNode head = createListNode(1);
		
		// Create a circular linked list with 10 nodes
		for (int i=2; i<=10; i++) {
			head = CircularLinkedListUtils.addNodeAtEnd(head, createListNode(i));
		}
		
		System.out.println("SIMPLE CIRCULAR LINKED LIST");
		printLinkedListStatus(head);
		
		head = CircularLinkedListUtils.mergeCircularLoopAtNthNode(head, 5);
		
		boolean hasCircularLoop = CircularLinkedListUtils.isCircularLoopLinkedList(head);
		System.out.println("List has loop? " + hasCircularLoop);
		
		if (hasCircularLoop) {
			System.out.println("Circular Loop Size: " + CircularLinkedListUtils.getCircularLoopLength(head));
			System.out.println("Circular Loop Start Node Number: " + CircularLinkedListUtils.findCirlarLoopStartNode(head));
		}
	}
	
	private static ListNode createListNode(int data) {
		ListNode node = new ListNode();
		node.setData(data);
		node.setNextListNode(node);
		return node;
	}
	
	private static void printLinkedListStatus(ListNode head) {
		CircularLinkedListUtils.printList(head);
	}
}
