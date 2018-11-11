package binaryTrees;

import java.util.Scanner;

public class Diameter {
	
	static Scanner s = new Scanner(System.in);
	
	public static int diameter (BinaryTreeNode<Integer> root) {
		//base case
		if (root == null) {
			return 0;
		}
		
		int option1 = height(root.left) + height(root.right);
		int option2 = diameter(root.left);
		int option3 = diameter(root.right);
		
		return Math.max(option1, Math.max(option2, option3));
	}

	private static int height (BinaryTreeNode<Integer> root) {
		//base case	
		if (root == null) {
			return 0;
		}
		
		int lh = height(root.left);
		int rh = height(root.right);
		return 1 + Math.max(lh, rh);
	}
	
	//Better approach to calculate diameter with a time complexity O(n)
	public static Pair<Integer, Integer> heightDiameter (BinaryTreeNode<Integer> root) {
		//base case
		if (root == null) {
			Pair<Integer, Integer> output = new Pair<>();
			output.first = 0;
			output.second = 0;
			return output;
		}
		
		//Recursion calls
		Pair<Integer, Integer> lo = heightDiameter(root.left);
		Pair<Integer, Integer> ro = heightDiameter(root.right);
		
		int height = 1 + Math.max(lo.first, ro.first);
		
		int option1 = lo.first + ro.first;
		int option2 = lo.second;
		int option3 = ro.second;
		
		int diameter = Math.max(option1, Math.max(option2, option3));
		
		Pair<Integer, Integer> output = new Pair<>();
		output.first = height;
		output.second = diameter;
		return output;
	}
	
	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
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
	
	public static void printLevelWise(BinaryTreeNode<Integer> root){
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
		printLevelWise(root);
//		System.out.println("Diameter: " + diameter(root));
		System.out.println("Height: " + heightDiameter(root).first);
		System.out.println("Diameter: " + heightDiameter(root).second);
	}

}
