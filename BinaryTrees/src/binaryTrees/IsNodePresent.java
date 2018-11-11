package binaryTrees;

import java.util.Scanner;

public class IsNodePresent {
	
	public static boolean isNodePresent(BinaryTreeNode<Integer> root,int x){
		//base case
		if (root == null) {
			return false;
		}
		
		boolean ans = root.data == x ? true : false;
	
		boolean smallAns = isNodePresent(root.left, x);
		if (smallAns == true) {
			return true;
		}
		smallAns = isNodePresent(root.right, x);
		if (smallAns == true) {
			return true;
		}

		return ans;
	}
	
	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
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
		int x = s.nextInt();
		System.out.println(isNodePresent(root, x));
	}

}
