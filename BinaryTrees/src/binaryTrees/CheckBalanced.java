package binaryTrees;

import java.util.Scanner;

public class CheckBalanced {
	
	private static int height(BinaryTreeNode<Integer> root) {
		//base case
		if (root == null) {
			return 0;
		}
		
		int lh = height(root.left);
		int rh = height(root.right);
		
		return 1 + Math.max(lh, rh);
	}
	
	public static boolean checkBalanced(BinaryTreeNode<Integer> root){
		
		if (root == null) {
			return true;
		}
		
		boolean ans = Math.abs(height(root.left) - height(root.right)) <= 1;
		
		boolean leftAns = checkBalanced(root.left);
		if (!leftAns) {
			return false;
		}
		
		boolean rightAns = checkBalanced(root.right);
		if (!rightAns) {
			return false;
		}
		
		return ans;	
	}

	static Scanner s = new Scanner(System.in);

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
		return root;
	}


	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		System.out.println(checkBalanced(root));
	}

}
