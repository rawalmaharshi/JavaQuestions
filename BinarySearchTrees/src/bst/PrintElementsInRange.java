package bst;

import java.util.Scanner;

public class PrintElementsInRange {
	
	public static void printNodeFromK1ToK2(BinaryTreeNode<Integer> root,int k1,int k2){
		if (root == null) {
			return;
		}
		
		if (k1 < root.data) {
			printNodeFromK1ToK2(root.left, k1, k2);
		}
		
		if (root.data >= k1 && root.data <= k2) {
			System.out.print(root.data + " ");
		}
		
		if (root.data < k2) {
			printNodeFromK1ToK2(root.right, k1, k2);
		}
				
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
		int k1 = s.nextInt();
		int k2 = s.nextInt();
		printNodeFromK1ToK2(root, k1, k2);
	}
}
