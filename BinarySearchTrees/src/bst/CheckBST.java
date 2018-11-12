package bst;

import java.util.Scanner;

public class CheckBST {
	
	private static int maximum(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		
		return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
	}
	
	private static int minimum(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		
		return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
	}
	
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		//base case
		if (root == null) {
			return true;
		}
		
		int leftMax = maximum(root.left);
		int rightMin = minimum(root.right);
		
		if (root.data <= leftMax || root.data > rightMin) {
			return false;
		}
		
		boolean isLeftBST = isBST(root.left);
		boolean isrightBST = isBST(root.right);
		
		if (isLeftBST && isrightBST) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isBST2Helper (BinaryTreeNode<Integer> root) {
		return isBST2(root).first;
	}
	
	public static Pair<Boolean, Pair<Integer, Integer>> isBST2 (BinaryTreeNode<Integer> root) {
		if (root == null) {
			Pair<Boolean, Pair<Integer, Integer>> output = new Pair<Boolean, Pair<Integer, Integer>>();
			output.first = true;
			output.second = new Pair<Integer, Integer>();
			output.second.first = Integer.MAX_VALUE;
			output.second.second = Integer.MIN_VALUE;
			return output;
		}
		
		Pair<Boolean, Pair<Integer, Integer>> leftOutput = isBST2(root.left);
		Pair<Boolean, Pair<Integer, Integer>> rightOutput = isBST2(root.right);
		
		int min = Math.min(root.data, Math.min(leftOutput.second.first, rightOutput.second.first));
		int max = Math.max(root.data, Math.max(leftOutput.second.second, rightOutput.second.second));
		
		boolean isBST = (root.data > leftOutput.second.second)
						&& (root.data <= rightOutput.second.first)
						&& leftOutput.first && rightOutput.first;
		
		Pair<Boolean, Pair<Integer, Integer>> output = new Pair<>();
		output.first = isBST;
		output.second = new Pair<Integer, Integer>();
		output.second.first = min;
		output.second.second = max;
		return output;
		
	}
	
	public static boolean isBST3 (BinaryTreeNode<Integer> root, int min, int max) {
		if (root == null) {
			return true;
		}
		
		if (root.data < min || root.data > max) {
			return false;
		}
		
		boolean isLeftOk = isBST3(root.left, min, root.data - 1);
		boolean isrightOk = isBST3(root.right, root.data, max);
		
		return isLeftOk && isrightOk;
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

	public static void printLevelWiseAtDiffLevel(BinaryTreeNode<Integer> root){
		QueueUsingLL<BinaryTreeNode<Integer>>  primary = new QueueUsingLL<BinaryTreeNode<Integer>>();
		QueueUsingLL<BinaryTreeNode<Integer>>  secondary = new QueueUsingLL<BinaryTreeNode<Integer>>();

		primary.enqueue(root);

		while(!primary.isEmpty()){
			BinaryTreeNode<Integer> current=null;
			try {
				current = primary.dequeue();
			} catch (QueueEmptyException e) {
				System.out.println("Not possible");
			}
			System.out.print(current.data + " ");
			if(current.left != null){
				secondary.enqueue(current.left);
			}
			if(current.right != null){
				secondary.enqueue(current.right);
			}
			if(primary.isEmpty()){
				QueueUsingLL<BinaryTreeNode<Integer>>  temp = secondary;
				secondary = primary;
				primary = temp;
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		System.out.println(isBST2Helper(root));
	}
}
