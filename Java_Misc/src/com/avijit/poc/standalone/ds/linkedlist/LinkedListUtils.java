package com.avijit.poc.standalone.ds.linkedlist;

public class LinkedListUtils {
	
	public static void printList(ListNode head) {
		
		if (head == null) {
			System.out.println("EMPTY LIST");
			return;
		}
		
		ListNode currentNode = head;
		
		StringBuilder builder = new StringBuilder("List: ");
		while (currentNode != null) {
			builder.append(currentNode.getData()).append(" -> ");
			currentNode = currentNode.getNextListNode();
		}
		
		System.out.println(builder.toString());
		return;
	}
	
	public static int getListLength(ListNode head) {
		
		int nodeCount = 0;
		
		if (head == null) {
			return 0;
		}
		
		ListNode currentNode = head;
		
		while (currentNode != null) {
			nodeCount++;
			currentNode = currentNode.getNextListNode();
		}
		
		return nodeCount;
	}
	
	public static ListNode addNodeAtBeginning(ListNode head, ListNode newNode) {
		
		if (head == null) {
			return newNode;
		}
		
		newNode.setNextListNode(head);
		return newNode;
	}
	
	public static ListNode addNodeAtEnd(ListNode head, ListNode newNode) {
		
		if (head == null) {
			return newNode;
		}
		
		ListNode currentNode = head;
		
		while (currentNode.getNextListNode() != null) {
			currentNode = currentNode.getNextListNode();
		}
		
		currentNode.setNextListNode(newNode);
		return head;
	}
	
	public static ListNode addNodeAtMiddle(ListNode head, ListNode newNode, int nodePosition) {
		
		if (head == null) {
			return newNode;
		}
		
		if (nodePosition == 1) {
			newNode.setNextListNode(head);
			return newNode;
		}
		
		int linkedListLength = getListLength(head);
		
		if (nodePosition > linkedListLength || nodePosition < 1) {
			System.out.println("NODE POSTION SHOULD BE BETWEEEN 1 AND " + linkedListLength);
			return head;
		}
		
		ListNode currentNode = head;
		
		int nodeCounter = 0;
		while (currentNode != null) {
			
			if (nodeCounter++ == (nodePosition-2)) {
				break;
			}

			currentNode = currentNode.getNextListNode();
		}
		
		newNode.setNextListNode(currentNode.getNextListNode());
		currentNode.setNextListNode(newNode);
		
		return head;
	}
	
	public static ListNode deleteFirstNode(ListNode head) {
		
		if (head == null) {
			throw new IllegalArgumentException("DELETE CALLED ON EMPTY LIST");
		}
		
		ListNode newHeadNode = head.getNextListNode();
		
		head.setNextListNode(null);
		head = null;

		return newHeadNode;
	}
	
	public static ListNode deleteLastNode(ListNode head) {
		
		if (head == null) {
			throw new IllegalArgumentException("DELETE CALLED ON EMPTY LIST");
		}
		
		ListNode currentNode = head;
		ListNode secondLastNode = head;
		
		while (currentNode.getNextListNode() != null) {
			secondLastNode = currentNode;
			currentNode = currentNode.getNextListNode();
		}

		secondLastNode.setNextListNode(null);
		currentNode.setNextListNode(null);
		currentNode = null;
		
		return head;
	}
	
	public static ListNode deleteNodeFromMiddle(ListNode head, int nodePosition) {
		
		if (head == null) {
			throw new IllegalArgumentException("DELETE CALLED ON EMPTY LIST");
		}
		
		if (nodePosition == 1) {
			return deleteFirstNode(head);
		}
		
		int linkedListLength = getListLength(head);
		
		if (nodePosition > linkedListLength || nodePosition < 1) {
			System.out.println("NODE POSTION SHOULD BE BETWEEEN 1 AND " + linkedListLength);
			return head;
		}
		
		ListNode tempNode = head;
		ListNode currentNode = head;
		
		int nodeCounter = 0;
		while (currentNode != null) {
			
			if (nodeCounter++ == (nodePosition-1)) {
				break;
			}

			tempNode = currentNode;
			currentNode = currentNode.getNextListNode();
		}
		
		tempNode.setNextListNode(currentNode.getNextListNode());
		currentNode.setNextListNode(null);
		currentNode = null;
		
		return head;
	}
}
