package com.avijit.poc.standalone.ds.linkedlist;

public class CircularLinkedListTester {

	public static void main(String[] args) {

		System.out.println("ADD NODE 99");
		ListNode head = createListNode(99);
		printLinkedListStatus(head);
		
		System.out.println("ADD NODE 12 AND 67 AT HEAD");
		head = CircularLinkedListUtils.addNodeAtBeginning(head, createListNode(12));
		head = CircularLinkedListUtils.addNodeAtBeginning(head, createListNode(67));
		printLinkedListStatus(head);
		
		System.out.println("DELETE FIRST NODE");
		head= CircularLinkedListUtils.deleteFirstNode(head);
		printLinkedListStatus(head);
				
		System.out.println("ADD NODE 1 AT END");
		head = CircularLinkedListUtils.addNodeAtEnd(head, createListNode(1));
		printLinkedListStatus(head);
		
		System.out.println("ADD NODE 39 AT HEAD");
		head = CircularLinkedListUtils.addNodeAtBeginning(head, createListNode(39));
		printLinkedListStatus(head);
		
		System.out.println("ADD NODE 17 AT MIDDLE POSITION 2");
		head = CircularLinkedListUtils.addNodeAtMiddle(head, createListNode(17), 2);
		printLinkedListStatus(head);
		
		System.out.println("DELET LAST NODE");
		head= CircularLinkedListUtils.deleteLastNode(head);
		printLinkedListStatus(head);
		
		System.out.println("ADD NODE 33 AND 41 AT HEAD");
		head = CircularLinkedListUtils.addNodeAtBeginning(head, createListNode(33));
		head = CircularLinkedListUtils.addNodeAtBeginning(head, createListNode(41));
		printLinkedListStatus(head);
		
		System.out.println("DELET 3RD NODE");
		head= CircularLinkedListUtils.deleteNodeFromMiddle(head, 3);
		printLinkedListStatus(head);
		
		head= CircularLinkedListUtils.addNodeAtBeginning(head, createListNode(89));
		printLinkedListStatus(head);
		
		System.out.println("SPLIT INTO TWO CIRCULAR LISTS");
		Object[] headNodes = CircularLinkedListUtils.splitCircularListInTwoCircularLists(head);
		printLinkedListStatus((ListNode)headNodes[0]);
		printLinkedListStatus((ListNode)headNodes[1]);
		
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
