package binaryTrees;

public class BinaryTreeUse {
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(3);
		
		root.left = node1;
		root.right = node2;
	}

}
