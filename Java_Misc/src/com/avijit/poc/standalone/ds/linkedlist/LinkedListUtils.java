package com.avijit.poc.standalone.ds.linkedlist;

public class LinkedListUtils {
	
	public static void printList(ListNode head) {
		
		if (head == null) {
			System.out.println("EMPTY LIST");
			return;
		}
		
		ListNode currentNode = head;
		
		StringBuilder builder = new StringBuilder("List [").append(getListLength(head)).append("] : ");
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
	
	/**
	 * User two pointer and set both of them to head.
	 * Move the fast pointer to nth node from start, once it reaches there now move both the pointers together until
	 * the fast pointer reaches the end.
	 * At this point the slow pointer will be at the nth node from the end.
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode getNthNodeFromEndOfLinkedList(ListNode head, int nthNodeNumber) {
		
		ListNode nthNodePointer = head;
		ListNode fastPointer = head;
		
		int counter = 0;
		while(fastPointer != null) {
			
			if (counter <= nthNodeNumber) {
				fastPointer = fastPointer.getNextListNode();
			}
			
			counter++;
			fastPointer = fastPointer.getNextListNode();
			nthNodePointer = nthNodePointer.getNextListNode();
		}
		
		return nthNodePointer;
	}
	
	public static ListNode reverseLinkedList(ListNode head) {
		
		ListNode tempNode = null;
		ListNode nextNode = head;
		
		while (head != null) {
			nextNode = nextNode.getNextListNode();
			head.setNextListNode(tempNode);
			tempNode = head;
			head = nextNode;
		}
		
		return tempNode;
	}
	
	public static ListNode insertNodeInSortedList(ListNode head, ListNode newNode) {
		
		ListNode currentNode = head;
		ListNode tempNode = head;
		while (tempNode != null) {
			
			if (newNode.getData() <= currentNode.getData()) {
				newNode.setNextListNode(currentNode);
				tempNode.setNextListNode(newNode);
				break;
			}
			
			tempNode = currentNode;
			currentNode = currentNode.getNextListNode();
		}
		
		return head;
	}
	
	public static ListNode findMiddleNodeOfLinkedList(ListNode head) {
		
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		
		if (head == null) {
			throw new IllegalArgumentException("EMPTY LIST");
		} else if (head.getNextListNode() == null) {
			return head;
		}
		
		while (fastPointer != null) {
			fastPointer = fastPointer.getNextListNode();
			
			if (fastPointer != null) {
				fastPointer = fastPointer.getNextListNode();
			} else {
				break;
			}
			
			slowPointer = slowPointer.getNextListNode();
		}
		
		
		return slowPointer;
	}
	
	public static boolean isEvenLengthLinkedList(ListNode head) {
	
		while (head != null && head.getNextListNode() != null) {
			head = head.getNextListNode().getNextListNode();
		}
			
		return (head == null) ? true : false;
	}
	
	public static void displayLinkedListFromEnd(ListNode node) {
		if (node == null) {
			return;
		}
		
		displayLinkedListFromEnd(node.getNextListNode());
		System.out.print(node.getData() + " -> ");
	}
	
	public static ListNode mergeTwoSortedListIntoSingleList(ListNode head1, ListNode head2) {
		
		ListNode result;
		
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		
		if (head1.getData() < head2.getData()) {
			result = head1;
			result.setNextListNode(mergeTwoSortedListIntoSingleList(head1.getNextListNode(), head2));
		} else {
			result = head1;
			result.setNextListNode(mergeTwoSortedListIntoSingleList(head1.getNextListNode(), head2));
		}
		
		return result;
	}
	
}
