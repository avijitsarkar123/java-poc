package com.avijit.poc.standalone.ds.linkedlist;

public class LinkedListTester {

	public static void main(String[] args) {

		System.out.println("ADD NODE 99");
		ListNode head = createListNode(99);
		printLinkedListStatus(head);
		
		System.out.println("ADD NODE 12 AND 67 AT HEAD");
		head = LinkedListUtils.addNodeAtBeginning(head, createListNode(12));
		head = LinkedListUtils.addNodeAtBeginning(head, createListNode(67));
		printLinkedListStatus(head);
		
		System.out.println("DELETE FIRST NODE");
		head= LinkedListUtils.deleteFirstNode(head);
		printLinkedListStatus(head);
				
		System.out.println("ADD NODE 1 AT END");
		head = LinkedListUtils.addNodeAtEnd(head, createListNode(1));
		printLinkedListStatus(head);
		
		System.out.println("ADD NODE 17 AT MIDDLE POSITION 2");
		head = LinkedListUtils.addNodeAtMiddle(head, createListNode(17), 2);
		printLinkedListStatus(head);
		
		System.out.println("DELET LAST NODE");
		head= LinkedListUtils.deleteLastNode(head);
		printLinkedListStatus(head);
		
		System.out.println("ADD NODE 33 AND 41 AT HEAD");
		head = LinkedListUtils.addNodeAtBeginning(head, createListNode(33));
		head = LinkedListUtils.addNodeAtBeginning(head, createListNode(41));
		printLinkedListStatus(head);
		
		System.out.println("DELET 3RD NODE");
		head= LinkedListUtils.deleteNodeFromMiddle(head, 3);
		printLinkedListStatus(head);
		
		System.out.println("LinkedList has loop? " + CircularLinkedListUtils.isCircularLoopLinkedList(head));
		
		int nthNode = 3;
		ListNode nthLinkedListNode = LinkedListUtils.getNthNodeFromEndOfLinkedList(head, nthNode);
		System.out.println(nthNode + " Node value: " + nthLinkedListNode.getData());
		
		head = LinkedListUtils.reverseLinkedList(head);
		printLinkedListStatus(head);
		
		// Create a sorted list of 5 nodes
		System.out.println("CREATE A 5 NODES SORTED LIST");
		head = createListNode(11);
		head = LinkedListUtils.addNodeAtEnd(head, createListNode(22));
		head = LinkedListUtils.addNodeAtEnd(head, createListNode(33));
		head = LinkedListUtils.addNodeAtEnd(head, createListNode(44));
		head = LinkedListUtils.addNodeAtEnd(head, createListNode(55));
		head = LinkedListUtils.addNodeAtEnd(head, createListNode(66));
		head = LinkedListUtils.addNodeAtEnd(head, createListNode(77));
		printLinkedListStatus(head);
		
		System.out.println("INSERT NODE OF VALUE 40");
		head = LinkedListUtils.insertNodeInSortedList(head, createListNode(40));
		printLinkedListStatus(head);
		
		ListNode middleNode = LinkedListUtils.findMiddleNodeOfLinkedList(head);
		System.out.println("MIDDLE NODE VALUE: " + middleNode.getData());
		
		System.out.println("PREVIOUS LIST EVEN? " + LinkedListUtils.isEvenLengthLinkedList(head));
		
		System.out.println("PREVIOUS LIST IN REVERSE ORDER");
		LinkedListUtils.displayLinkedListFromEnd(head);
	}
	
	private static ListNode createListNode(int data) {
		ListNode node = new ListNode();
		node.setData(data);
		node.setNextListNode(null);
		return node;
	}
	
	private static void printLinkedListStatus(ListNode head) {
		LinkedListUtils.printList(head);
	}
}
