package binaryTrees;

import java.util.Scanner;

public class BinaryTreeUse3 {
	
	public static BinaryTreeNode<Integer> takeInputLevelWise () {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		
		if (rootData == -1) {
			s.close();
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		pendingNodes.enqueue(root);
		
		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> front = null;
			try {
				front = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				//should not reach here
			}
			
			System.out.println("Enter the left child of " + front.data);
			int leftChild = s.nextInt();
			if (leftChild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftChild);
				front.left = child;
				pendingNodes.enqueue(child);
			}
			
			System.out.println("Enter the right child of " + front.data);
			int rightChild = s.nextInt();
			if (rightChild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(rightChild);
				front.right = child;
				pendingNodes.enqueue(child);
			}
			
		}
		s.close();
		return root;
	}
	
	public static void printTreeLevelWise (BinaryTreeNode<Integer> root) {
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		pendingNodes.enqueue(root);
		
		while(!pendingNodes.isEmpty()) {
			try {
				BinaryTreeNode<Integer> front = pendingNodes.dequeue();
				String op = front.data + ":";
				if (front.left != null) {
					pendingNodes.enqueue(front.left);
					op += "L:" + front.left.data + ",";
				} else {
					op += "L:" + -1 + ",";
				}
				
				if (front.right != null) {
					pendingNodes.enqueue(front.right);
					op += "R:" + front.right.data ;
				} else {
					op += "R:" + -1;
				}
				System.out.println(op);
				
			} catch (QueueEmptyException e){
				//doesn't reach here
			}
		}
	}
	
	public static void printTree (BinaryTreeNode<Integer> root) {
		// base case
		if (root == null) {
			return;
		}
		
		String toBePrinted = root.data + " --> ";
		if (root.left != null) {
			toBePrinted += "L:" + root.left.data + ", ";
		}
		
		if (root.right != null) {
			toBePrinted += "R: " + root.right.data;
		}
		
		System.out.println(toBePrinted);
		
		printTree(root.left);
		printTree(root.right);
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		printTreeLevelWise(root);
	}

}
