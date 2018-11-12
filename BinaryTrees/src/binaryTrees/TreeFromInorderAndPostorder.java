package binaryTrees;

import java.util.Scanner;

public class TreeFromInorderAndPostorder {
	
	private static BinaryTreeNode<Integer> buildTreeHelper(int[] post, int[] in, int posS, int posE, int inS, int inE) {
		//base case
		if (inS > inE) {
			return null;
		}
		
		int rootData = post[posE];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		int rootIndex = -1;
		
		for (int i = inS; i <= inE; i++) {
			if (in[i] == rootData) {
				rootIndex = i;
				break;
			}
		}
		
		if (rootIndex == -1) {
			return null;
		}
		
		int leftIS = inS;
		int leftIE = rootIndex - 1;
		int leftPS = posS;
		int leftPE = leftIE - leftIS + leftPS;
		int rightIS = rootIndex + 1;
		int rightIE = inE;
		int rightPS = leftPE + 1;
		int rightPE = posE - 1;
		
		root.left = buildTreeHelper (post, in, leftPS, leftPE, leftIS, leftIE);
		root.right = buildTreeHelper (post, in, rightPS, rightPE, rightIS, rightIE);
		
		return root;
	}
	
	public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int[] post, int[] in){
		return buildTreeHelper(post, in , 0, post.length - 1 , 0, in.length - 1);
	}
	
	static Scanner s = new Scanner(System.in);

	public static void printLevelWiseAtDiffLine(BinaryTreeNode<Integer> root){
		QueueUsingLL<BinaryTreeNode<Integer>>  primary = new QueueUsingLL<>();
		QueueUsingLL<BinaryTreeNode<Integer>>  secondary = new QueueUsingLL<>();

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
		int[] post = new int[size];
		for(int i = 0; i < size; i++){
			post[i] = s.nextInt();
		}
		int in[] = new int[size];
		for(int i = 0; i < size; i++){
			in[i] = s.nextInt();
		}
		BinaryTreeNode<Integer> root = getTreeFromPostorderAndInorder(post, in);
		printLevelWiseAtDiffLine(root);
		
	}
}
