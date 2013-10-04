package com.avijit.poc.standalone.ds.linkedlist;


public class CircularLinkedListUtils {
	
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
			
			if (currentNode == head) {
				break;
			}
		}
		
		builder.append(head.getData());
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
			if (currentNode == head) {
				break;
			}
		}
		
		return nodeCount;
	}
	
	public static ListNode getListNodeAddressForNthNode(ListNode head, int nodePosition) {
		
		int nodeCounter = 0;
				
		int listLength = getListLength(head);
		if (listLength < nodePosition || nodePosition < 1) {
			throw new IllegalArgumentException("INVALID NODE POSITION VALUE, IT SHOULD BE WITHIN 1 AND " + listLength);
		}
		
		ListNode currentNode = head;
		while (currentNode != null) {
			
			if (++nodeCounter == nodePosition) {
				break;
			}
			currentNode = currentNode.getNextListNode();
		}
		
		return currentNode;
	}
	
	public static ListNode mergeCircularLoopAtNthNode(ListNode head, int nodePosition) {
		
		ListNode nthNodeAddress = getListNodeAddressForNthNode(head, nodePosition);
		
		if (nthNodeAddress != null) {
			
			ListNode currentNode = head;
			while(currentNode != null) {
				
				currentNode = currentNode.getNextListNode();
				if (currentNode.getNextListNode() == head) {
					break;
				}
			}
			
			currentNode.setNextListNode(nthNodeAddress);
		}
		
		return head;
	}
	
	/**
	 * The logic is to use two pointer, one slow which moves one at a time and another fast
	 * which moves two at a time. If both the pointers ever meet then it has a circular loop 
	 * 
	 * @param head
	 * @return
	 */
	public static boolean isCircularLoopLinkedList(ListNode head) {
		
		if (head == null) {
			return false;
		}
		
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		
		while (slowPointer != null && fastPointer != null) {

			fastPointer = fastPointer.getNextListNode();
			if (fastPointer == null) {
				return false;
			}
			if (fastPointer == slowPointer) {
				return true;
			}
			
			fastPointer = fastPointer.getNextListNode();
			if (fastPointer == slowPointer) {
				return true;
			}
			
			slowPointer = slowPointer.getNextListNode();
		}
		
		return false;
	}
	
	/**
	 * The logic is to use two pointer, one slow which moves one at a time and another fast
	 * which moves two at a time. If both the pointers ever meet then it has a circular loop 
	 * 
	 * Once you get a loop, now both the slow and the fast pointer are at the same node.
	 * Keep the slow pointer there and move the fast pointer in a loop until they are again equal.
	 * The above loop count is the length of the circular loop.
	 * 
	 * @param head
	 * @return
	 */
	public static int getCircularLoopLength(ListNode head) {
		
		if (head == null) {
			return 0;
		}
		
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		
		boolean hasCircularLoop = false;
		while (slowPointer != null && fastPointer != null) {

			fastPointer = fastPointer.getNextListNode();
			if (fastPointer == null) {
				break;
			}
			if (fastPointer == slowPointer) {
				hasCircularLoop = true;
				break;
			}
			
			fastPointer = fastPointer.getNextListNode();
			if (fastPointer == slowPointer) {
				hasCircularLoop = true;
				break;
			}
			
			slowPointer = slowPointer.getNextListNode();
		}
		
		int circularLoopSize = 0;
		if (hasCircularLoop) {
			fastPointer = fastPointer.getNextListNode();
			while(fastPointer != slowPointer) {
				fastPointer = fastPointer.getNextListNode();
				circularLoopSize++;
			}
		}
		
		return circularLoopSize;
	}
	
	public static int findCirlarLoopStartNode(ListNode head) {
		
		if (head == null) {
			return 0;
		}
		
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		
		boolean hasCircularLoop = false;
		while (slowPointer != null && fastPointer != null) {

			fastPointer = fastPointer.getNextListNode();
			if (fastPointer == null) {
				break;
			}
			if (fastPointer == slowPointer) {
				hasCircularLoop = true;
				break;
			}
			
			fastPointer = fastPointer.getNextListNode();
			if (fastPointer == slowPointer) {
				hasCircularLoop = true;
				break;
			}
			
			slowPointer = slowPointer.getNextListNode();
		}

		int counter = 0;
		if (hasCircularLoop) {
			slowPointer = head;
			fastPointer = fastPointer.getNextListNode();
			while (slowPointer != fastPointer) {
				fastPointer = fastPointer.getNextListNode();
				slowPointer = slowPointer.getNextListNode();
				counter++;
			}
		}
		
		return counter;
	}
	
	public static ListNode addNodeAtBeginning(ListNode head, ListNode newNode) {
		
		if (head == null) {
			return newNode;
		}
		
		ListNode currentNode = head;
		while (currentNode != null) {
			currentNode = currentNode.getNextListNode();
			
			if (currentNode.getNextListNode() == head) {
				break;
			}
		}

		newNode.setNextListNode(head);
		currentNode.setNextListNode(newNode);
		return newNode;
	}
	
	public static ListNode addNodeAtEnd(ListNode head, ListNode newNode) {
		
		if (head == null) {
			return newNode;
		}
		
		ListNode currentNode = head;
		
		while (currentNode.getNextListNode() != head) {
			currentNode = currentNode.getNextListNode();
		}
		
		currentNode.setNextListNode(newNode);
		newNode.setNextListNode(head);
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
		ListNode currentNode = head;
		
		while (currentNode != null) {
			currentNode = currentNode.getNextListNode();
			
			if (currentNode.getNextListNode() == head) {
				break;
			}
		}
		
		currentNode.setNextListNode(newHeadNode);
		
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
		
		while (currentNode != null) {
			secondLastNode = currentNode;
			currentNode = currentNode.getNextListNode();
			
			if (currentNode.getNextListNode() == head) {
				break;
			}
		}

		secondLastNode.setNextListNode(head);
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
	
	public static Object[] splitCircularListInTwoCircularLists(ListNode head) {
		
		ListNode head1;
		ListNode head2;
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		
		while (fastPointer.getNextListNode() != head && fastPointer.getNextListNode().getNextListNode() != head) {
			fastPointer = fastPointer.getNextListNode().getNextListNode();
			slowPointer = slowPointer.getNextListNode();
		}
		
		//Check for Even
		if (fastPointer.getNextListNode().getNextListNode() == head) {
			fastPointer = fastPointer.getNextListNode();
		}
		
		head2 = slowPointer.getNextListNode();
		fastPointer.setNextListNode(head2);
		
		slowPointer.setNextListNode(head);
		head1 = head;
		
		return new Object[] {head1, head2};
	}
}
