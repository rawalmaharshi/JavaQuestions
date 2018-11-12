package binaryTrees;

import java.util.Scanner;

public class TreeFromInorderAndPreorder {
	
	private static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder (int[] preorder, int[] inorder, int preSI, int preEI, int inSI, int inEI) {
		//base case
		if (inSI > inEI) {
			return null;
		}
		
		int rootData = preorder[preSI];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		int rootIndex = -1;
		for (int i = inSI ; i <= inEI; i++) {
			if (inorder[i] == rootData) {
				rootIndex = i;
				break;
			}
		}
		
		//if element not found (input is wrong)
		if (rootIndex == -1) {
			return null;
		}
		
		int leftIOsI = inSI;
		int leftIOeI = rootIndex - 1;
		int leftPOsI = preSI + 1;
		int leftPOeI = leftIOeI - leftIOsI + leftPOsI ;
		int rightIOsI = rootIndex + 1;
		int rightIOeI = inEI;
		int rightPOsI = leftPOeI + 1;
		int rightPOeI = preEI;
		
		root.left = getTreeFromPreorderAndInorder(preorder, inorder, leftPOsI, leftPOeI, leftIOsI, leftIOeI);
		root.right = getTreeFromPreorderAndInorder(preorder, inorder, rightPOsI, rightPOeI, rightIOsI, rightIOeI);
		
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
