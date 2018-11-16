package bst;

import java.util.Scanner;
import java.util.ArrayList;

public class PathToNode {
	
	public static ArrayList<Integer> findPathBT(BinaryTreeNode<Integer> root, int data){
		if (root == null) {
			return null;
		}
		
		if (root.data == data) {
			ArrayList<Integer> output = new ArrayList<>();
			output.add(root.data);
			return output;
		}
		
		ArrayList<Integer> leftOutput = findPathBT(root.left, data);
		if (leftOutput != null) {
			leftOutput.add(root.data);
			return leftOutput;
		}
		
		ArrayList<Integer> rightOutput = findPathBT(root.right, data);
		if (rightOutput != null) {
			rightOutput.add(root.data);
			return rightOutput;
		} else {
			return null;
		}
	}
	
	public static ArrayList<Integer> findPath(BinaryTreeNode<Integer> root, int data){
		if (root == null) {
			return null;
		}
		
		if (root.data == data) {
			ArrayList<Integer> output = new ArrayList<>();
			output.add(root.data);
			return output;
		} 
		
		if (root.data > data) {
			ArrayList<Integer> leftOutput = findPath(root.left, data);
			if (leftOutput != null) {
				leftOutput.add(root.data);
				return leftOutput;
			}  
		} 
		
		if (root.data < data) {
			ArrayList<Integer> rightOutput = findPath(root.right, data);
			if (rightOutput != null) {
				rightOutput.add(root.data);
				return rightOutput;
			} 
		} 
		
		return null;
	}
	
	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); // we can skip writing again inside <> after java version 1.7 
		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = s.nextInt();
			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = s.nextInt();
			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		int data = s.nextInt();
		ArrayList<Integer> output = findPath(root, data);
		if(output != null) {
			for(int i : output) {
				System.out.println(i);
			}
		}
	}
	
}
