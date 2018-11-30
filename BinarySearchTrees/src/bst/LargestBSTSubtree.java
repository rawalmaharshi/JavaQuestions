package bst;

import java.util.Scanner;

class TreeProps {
	public int min;
	public int max;
	public boolean isBST;
	public int height;
}

public class LargestBSTSubtree {
	
	private static TreeProps largestBSTSubtreeHelper (BinaryTreeNode<Integer> root) {
		//base case
		if (root == null) {
			TreeProps op = new TreeProps();
			op.height = 0;
			op.min = Integer.MAX_VALUE;
			op.max = Integer.MIN_VALUE;
			op.isBST = true;
			return op; 
		}
		
		TreeProps leftOutput = largestBSTSubtreeHelper(root.left);
		TreeProps rightOutput = largestBSTSubtreeHelper(root.right);
		
		int min = Math.min(root.data, Math.min(leftOutput.min, rightOutput.min));
		int max = Math.max(root.data, Math.max(leftOutput.max, rightOutput.max));
		
		boolean isBST = (root.data > leftOutput.max) && (root.data <= rightOutput.min) && leftOutput.isBST && rightOutput.isBST;
		
		TreeProps output = new TreeProps();
		output.isBST = isBST;
		output.max = max;
		output.min = min;
		
		if (leftOutput.isBST == true && rightOutput.isBST == true) {
			output.height = 1 + Math.max(leftOutput.height, rightOutput.height);
		}
		
		if (!leftOutput.isBST || !rightOutput.isBST) {
			output.height = Math.max(leftOutput.height, rightOutput.height);
		}
		return output;
	}
	
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		return largestBSTSubtreeHelper(root).height;
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
		System.out.println(largestBSTSubtree(root));
	}
}
