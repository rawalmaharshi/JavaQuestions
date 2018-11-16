package bst;

import java.util.Scanner;

public class LCABinaryTree {
	
	public static int lcaBinaryTree(BinaryTreeNode <Integer> root , int a, int b){
		// base case
		if (root == null) {
			return -1;
		}
		
		if (root.data == a || root.data == b) {
			return root.data;
		}
		
		int n1 = lcaBinaryTree(root.left, a, b);
		int n2 = lcaBinaryTree(root.right, a, b);
		
		if (n1 != -1 && n2 != -1) {
			return root.data;
		} else if (n1 == -1) {
			return n2;
		} else {
			return n1;
		}
	}
	
	static Scanner s = new Scanner(System.in);
	static int a ;
	static int b;

	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); // we can skip writing again inside <> after java version 1.7
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
	    a = s.nextInt();
	    b = s.nextInt();
		return root;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();

		System.out.println(lcaBinaryTree(root, a, b));
	}
}
