package com.avijit.poc.standalone.ds.trees;

public class BinaryTreeNode implements Comparable<BinaryTreeNode>{
	
	private int data;
	private int height = 0;
	private BinaryTreeNode leftChildNode;
	private BinaryTreeNode rightChildNode;
	
	private BinaryTreeNode parentNode;
	
	public BinaryTreeNode(){}
	
	public BinaryTreeNode(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public BinaryTreeNode getLeftChildNode() {
		return leftChildNode;
	}
	public void setLeftChildNode(BinaryTreeNode leftChildNode) {
		this.leftChildNode = leftChildNode;
	}
	public BinaryTreeNode getRightChildNode() {
		return rightChildNode;
	}
	public void setRightChildNode(BinaryTreeNode rightChildNode) {
		this.rightChildNode = rightChildNode;
	}
	public BinaryTreeNode getParentNode() {
		return parentNode;
	}
	public void setParentNode(BinaryTreeNode parentNode) {
		this.parentNode = parentNode;
	}
	
	@Override
	public int compareTo(BinaryTreeNode o) {
		if (o == null || o.getData() == 0) {
			return 0;
		}
		
		if (o.getData() < data) {
			return 1;
		} else {
			return -1;
		}
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		str.append("Node Value: ").append(data);
		str.append("Node Height: ").append(height);
		
		if (leftChildNode != null) {
			str.append(" Left Child Node Value: ").append(leftChildNode.getData());
		}
		
		if (rightChildNode != null) {
			str.append(" Right Child Node Value: ").append(rightChildNode.getData());
		}
		
		return str.toString();
	}
}
