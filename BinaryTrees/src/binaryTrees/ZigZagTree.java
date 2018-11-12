package binaryTrees;

import java.util.Scanner;
import java.util.Stack;

public class ZigZagTree {
	
	public static void printZigZag(BinaryTreeNode<Integer> root) {
		
		Stack<BinaryTreeNode<Integer>> stack1 = new Stack<>();
		Stack<BinaryTreeNode<Integer>> stack2 = new Stack<>();
		
		stack1.push(root);
		
		while (!stack1.empty() || !stack2.empty()) {
			
			while (!stack1.empty()) {
				BinaryTreeNode<Integer> curr = stack1.pop();
				if (curr.left != null) {
					stack2.push(curr.left);
				}
				
				if (curr.right != null) {
					stack2.push(curr.right);
				}
				
				System.out.print(curr.data + " ");
			}
			System.out.println();
			
			while (!stack2.empty()) {
				BinaryTreeNode<Integer> curr = stack2.pop();
				if (curr.right != null) {
					stack1.push(curr.right);
				}
				
				if (curr.left != null) {
					stack1.push(curr.left);
				}
				
				System.out.print(curr.data + " ");
			}
			System.out.println();
		}
	
	}

	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
		Scanner s = new Scanner(System.in);
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
		printZigZag(root);
	}
}
