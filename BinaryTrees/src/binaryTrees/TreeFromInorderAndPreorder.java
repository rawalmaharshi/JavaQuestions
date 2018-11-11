package binaryTrees;

import java.util.Scanner;

public class TreeFromInorderAndPreorder {
	
	private static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder (int[] preorder, int[] inorder, int preSI, int preEI, int inSI, int inEI) {
		//base case
		if (preSI > preEI) {
			BinaryTreeNode<Integer> op = new BinaryTreeNode<Integer>(preorder[preSI]);
			return op;
		}
		
		int root = preorder[preSI];
		int i = 0;
		int minilength = 0;
		int leftTreeIOsI = 0, leftTreeIOeI = 0;
		int rightTreeIOsI = 0, rightTreeIOeI = 0;
		for ( ; i < inorder.length; i++) {
			minilength++;
			if (inorder[i] == root)
				break;	
		}
		leftTreeIOsI = inSI;
		leftTreeIOeI = i - 1;
		
		int leftInorder[] = new int[minilength];
		for (i = 0; i < minilength; i++) 
			leftInorder[i] = inorder[i];
		
		int rightInorder[] = new int[minilength];
		for (int k = 0, j = i + 1; k < minilength; k++, j++) {
			rightInorder[k] = inorder[j];
		}
		
		//Iske upar left Inorder aur right inorder tayaar hai
		
		int [] leftPreorder = new int[minilength];
		int [] rightPreorder = new int[minilength];
		int leftTreePOsI = preSI + 1, leftTreePOeI = 0;
		int rightTreePOsI = 0, rightTreePOeI = 0;
		
		i = 0;
		int j = preSI + 1;
		for ( ; i < minilength; i++, j++) {
			leftPreorder[i] = preorder[j];
		}
		
		leftTreePOeI = i -1;
		rightTreePOsI = i;
		for (j = 0; j < minilength; i++, j++) {
			rightPreorder[j] = preorder[i];
		}
		rightTreePOeI = i -1;
		
		// Iske upar baki ka maal tayaar hai
		
		getTreeFromPreorderAndInorder(leftPreorder, leftInorder, leftTreePOsI, leftTreePOeI, leftTreeIOsI, leftTreeIOeI);
		getTreeFromPreorderAndInorder(rightPreorder, rightInorder, rightTreePOsI, rightTreePOeI, rightTreeIOsI, rightTreeIOeI);
		
		return root;
	}
	
	public static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[] pre, int[] in){
		return getTreeFromPreorderAndInorder(pre, in, 0, pre.length - 1, 0, in.length - 1);
	}
	
	static Scanner s = new Scanner(System.in);

	public static void printLevelWiseAtDiffLine(BinaryTreeNode<Integer> root){
		if(root == null) {
			return;
		}
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
		
		int size = s.nextInt();
		int[] pre = new int[size];
		for(int i = 0; i < size; i++){
			pre[i] = s.nextInt();
		}
		int in[] = new int[size];
		for(int i = 0; i < size; i++){
			in[i] = s.nextInt();
		}
		BinaryTreeNode<Integer> root = getTreeFromPreorderAndInorder(pre, in);
		printLevelWiseAtDiffLine(root);
		
	}
}
