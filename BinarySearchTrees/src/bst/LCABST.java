package bst;

import java.util.Scanner;

public class LCABST {
	
	private static BinaryTreeNode<Integer> lcaInBSTHelper(BinaryTreeNode<Integer> root , int a , int b){
		//base case
		if (root == null) {
			return null;
		}
		
		if (root.data == a || root.data == b) {
			return root;
		}
		
		if (root.data > a && root.data > b) {
			return lcaInBSTHelper(root.left, a, b);
		} else if (root.data < a && root.data < b) {
			return lcaInBSTHelper(root.right, a, b);
		} else {
			BinaryTreeNode<Integer> left_lca = lcaInBSTHelper(root.left, a, b);
			BinaryTreeNode<Integer> right_lca = lcaInBSTHelper(root.right, a, b);
			if (left_lca != null && right_lca != null) {
				return root;
			} else if (left_lca != null) {
				return left_lca;
			} else {
				return right_lca;
			}
		}
		
	}
	
	public static int lcaInBST (BinaryTreeNode<Integer> root, int a, int b) {
		BinaryTreeNode<Integer> node = lcaInBSTHelper(root, a, b);
		if (node != null) {
			return node.data;
		} else {
			return -1;
		}
	}
	
	static Scanner s = new Scanner(System.in);
	static int a;
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
		System.out.println(lcaInBST(root, a, b));
	}

}
