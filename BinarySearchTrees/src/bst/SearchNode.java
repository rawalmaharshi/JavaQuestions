package bst;

import java.util.Scanner;

public class SearchNode {
	
	public static BinaryTreeNode<Integer> searchInBST(BinaryTreeNode<Integer> root , int k){
		//base case
		if (root == null) {
			return null;
		}
		
		BinaryTreeNode<Integer> ans = null;
		if (k == root.data) {
			ans = root;
			return ans;
		}
		
		if (k >= root.data)
			ans = searchInBST(root.right, k);
		else
			ans = searchInBST(root.left, k);
		
		return ans;
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
		int k = s.nextInt();
		BinaryTreeNode<Integer> ans = searchInBST(root, k);
		if(ans != null) {
			System.out.println(ans.data);
		}
	}

}
