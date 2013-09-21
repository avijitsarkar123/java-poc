package com.avijit.poc.standalone.ds.trees;

public class BSTTester {
	public static void main(String[] args) {
		
		int [] values = {2, 4, 3, 9, 11, 5, 7, 18, 14, 23, 6};
		
		BinarySearchTree bst = new BinarySearchTree();
		
		for (int value : values) {
			BinaryTreeNode node = new BinaryTreeNode(value);
			bst.insertNode(node);
		}
		
		bst.displayBST(bst.getRoot());
		
		bst.searchinBST(9, bst.getRoot());
		
	}
}
