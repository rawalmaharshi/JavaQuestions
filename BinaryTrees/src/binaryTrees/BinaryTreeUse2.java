package binaryTrees;

import java.util.Scanner;

public class BinaryTreeUse2 {
	
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
			toBePrinted += "R:" + root.right.data;
		}
		
		System.out.println(toBePrinted);
		
		printTree(root.left);
		printTree(root.right);
	}
	
	public static BinaryTreeNode<Integer> takeInput (Scanner s) {
		int rootData;
		System.out.println("Enter root data");
		rootData = s.nextInt();
		if (rootData == -1) {
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		root.left = takeInput(s);
		root.right = takeInput(s);
		return root;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInput(s);
		printTree(root);
		s.close();
	}

}
