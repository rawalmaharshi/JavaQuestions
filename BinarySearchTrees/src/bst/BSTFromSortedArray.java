package bst;

import java.util.Scanner;

public class BSTFromSortedArray {
	
	private static BinaryTreeNode<Integer> sortedArrayToBSTHelper(int[] arr, int sI, int eI) {
		//base case
		if (sI > eI) {
			return null;
		}
		
		int midIndex = (eI + sI) / 2;
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[midIndex]);
		
		root.left = sortedArrayToBSTHelper(arr, sI, midIndex - 1);
		root.right = sortedArrayToBSTHelper(arr, midIndex + 1, eI);
		
		return root;
	}
	
	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr){
		return sortedArrayToBSTHelper (arr, 0, arr.length - 1);
	}
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int len = sc.nextInt();
		int[] arr = new int[len];
		for(int i = 0; i < len; ++i) {
			arr[i] = sc.nextInt();
		}
		BinaryTreeNode<Integer> ans = SortedArrayToBST(arr);
		
		preOrder(ans);
	}
	
	private static void preOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}

}
