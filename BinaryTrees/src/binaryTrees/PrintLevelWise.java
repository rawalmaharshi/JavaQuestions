package binaryTrees;

import java.util.Scanner;

public class PrintLevelWise {
	
	public static void printLevelWise(BinaryTreeNode<Integer> root){
		if (root == null) {
			return;
		}
		
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		pendingNodes.enqueue(root);
		pendingNodes.enqueue(null);
		
		while (!pendingNodes.isEmpty()) {
			try {
				BinaryTreeNode<Integer> currNode = pendingNodes.dequeue();
				
				if (currNode != null) {
					System.out.print(currNode.data +  " ");
					if (currNode.left != null) {
						pendingNodes.enqueue(currNode.left);
					}
					
					if (currNode.right != null) {
						pendingNodes.enqueue(currNode.right);
					}
				}
				
				else  {
					//Queue is not empty (still has other nodes)
					if (!pendingNodes.isEmpty()) {
						System.out.println();
						pendingNodes.enqueue(null);
					}
					else {
						break;
					}
				}
				
				
			} catch (QueueEmptyException e) {
				//Doesn't reach here
			}
			
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
		printLevelWise(root);
	}
}
