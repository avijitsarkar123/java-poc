package com.avijit.poc.standalone.ds.trees;

public class BinarySearchTree {
	private BinaryTreeNode root;
	
	public BinaryTreeNode getRoot() {
		return this.root;
	}
	
	public void searchinBST(int value, BinaryTreeNode node) {
		
		if (node.getData() == value) {
			System.out.println(node);
			return;
		}
		
		if (node.getLeftChildNode() != null) {
			searchinBST(value, node.getLeftChildNode());
		}
		
		if (node.getRightChildNode() != null) {
			searchinBST(value, node.getRightChildNode());
		}
	}
	
	public void displayBST(BinaryTreeNode node) {

		System.out.println(node);
		
		if (node.getLeftChildNode() != null) {
			displayBST(node.getLeftChildNode());
		} 
		
		if (node.getRightChildNode() != null) {
			displayBST(node.getRightChildNode());
		}
		
	}
	
	public void insertNode(BinaryTreeNode node) {

		if (root == null) {
			root = node;
			root.setHeight(node.getHeight()+1);
		} else {
			node.setHeight(node.getHeight()+1);
			insert(node, root);
		}
		
	}
	
	public void balancedBST() {
		
	}
	
	private void insert(BinaryTreeNode node, BinaryTreeNode parentNode) {

		if (node.compareTo(parentNode) < 0) { //It will go to the left of parent node
			
			if (parentNode.getLeftChildNode() == null) { // If no left child, make it left child
				parentNode.setLeftChildNode(node);
				node.setParentNode(parentNode);
				
			} else {
				insert(node, parentNode.getLeftChildNode()); // If left child present then insert it under left child.
			}
			
		} else { // It will go to the right of parent node
			
			if (parentNode.getRightChildNode() == null) { // If no right child, make it right child
				parentNode.setRightChildNode(node);
				node.setParentNode(parentNode);
				
			} else {
				insert(node, parentNode.getRightChildNode()); // If left child present then insert it under left child.
			}
			
		}
		
		node.setHeight(node.getHeight()+1);
	}
	
}
