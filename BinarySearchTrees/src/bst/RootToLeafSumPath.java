package bst;

import java.util.Scanner;

public class RootToLeafSumPath {
	
	private static void rootToLeafSumPathHelper (BinaryTreeNode<Integer> root, int k, String op) {
		//base case
		if (root == null) {
			return;
		}
		
		op += root.data + " ";
		if (root.data == k) {
			System.out.println(op);
		}
		
		rootToLeafSumPathHelper(root.left, k - root.data, op);
		rootToLeafSumPathHelper(root.right, k - root.data, op);
	}
	
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
		// Write your code here
		rootToLeafSumPathHelper(root, k, "");
	}
	
	static Scanner s = new Scanner(System.in);
	static int k;

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
		k = s.nextInt();
		return root;
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		rootToLeafPathsSumToK(root,k);
	}

}
