package bst;

import java.util.Scanner;

public class ReplaceWithLargerNodesSum {

	private static int replaceHelper (BinaryTreeNode<Integer> root, int sum) {
		//base case
		if (root == null) {
			return 0 ;
		}
		
		sum += root.data;
//		sum += replaceHelper(root.right, sum);
		root.data = sum;
		return sum;
	}

	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		replaceHelper (root, 0);
	}

	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput() {
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = s.nextInt();
			if (leftChildData != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = s.nextInt();
			if (rightChildData != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
	}

	public static void printLevelWiseAtDiffLevel(BinaryTreeNode<Integer> root) {
		QueueUsingLL<BinaryTreeNode<Integer>> primary = new QueueUsingLL<BinaryTreeNode<Integer>>();
		QueueUsingLL<BinaryTreeNode<Integer>> secondary = new QueueUsingLL<BinaryTreeNode<Integer>>();

		primary.enqueue(root);

		while (!primary.isEmpty()) {
			BinaryTreeNode<Integer> current = null;
			try {
				current = primary.dequeue();
			} catch (QueueEmptyException e) {
				System.out.println("Not possible");
			}
			System.out.print(current.data + " ");
			if (current.left != null) {
				secondary.enqueue(current.left);
			}
			if (current.right != null) {
				secondary.enqueue(current.right);
			}
			if (primary.isEmpty()) {
				QueueUsingLL<BinaryTreeNode<Integer>> temp = secondary;
				secondary = primary;
				primary = temp;
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		replaceWithLargerNodesSum(root);
		printLevelWiseAtDiffLevel(root);
	}
}
