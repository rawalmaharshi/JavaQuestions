package binaryTrees;

import java.util.ArrayList;
import java.util.Scanner;

public class LevelWiseLinkedList {
	
	public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return null;
		}
		
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		pendingNodes.enqueue(root);
		pendingNodes.enqueue(null);
		
		Node<BinaryTreeNode<Integer>> head = null;
		Node<BinaryTreeNode<Integer>> tail = null;
		ArrayList<Node<BinaryTreeNode<Integer>>> output = new ArrayList<>();
		
		while (!pendingNodes.isEmpty()) {
			try {
				BinaryTreeNode<Integer> currNode = pendingNodes.dequeue();
				if (currNode != null) {
					if (currNode.left != null) {
						pendingNodes.enqueue(currNode.left);
					}
					
					if (currNode.right != null) {
						pendingNodes.enqueue(currNode.right);
					}
										
					Node<BinaryTreeNode<Integer>> newNode = new Node<>(currNode);
					if (head == null) {
						head = newNode;
						tail = newNode;
					} else {
						tail.next = newNode;
						tail = newNode;
					}
				} else if (currNode == null){
					// i.e. when current node is null (line break)
					output.add(head);
					head = null;
					tail = null;
					
					if (!pendingNodes.isEmpty()) {
						pendingNodes.enqueue(null);
					} else {
						break;
					}
				}	
			} catch (QueueEmptyException e) {
				//Doesn't reach here
			}
		}
		return output;
	}

	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
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
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		ArrayList<Node<BinaryTreeNode<Integer>>> output = LLForEachLevel(root);
		for(Node<BinaryTreeNode<Integer>> head : output){
			Node<BinaryTreeNode<Integer>> temp = head;
			while(temp != null){
				System.out.print(temp.data.data + " ") ;
				temp = temp.next;
			}
			System.out.println();
		}
	}

}
