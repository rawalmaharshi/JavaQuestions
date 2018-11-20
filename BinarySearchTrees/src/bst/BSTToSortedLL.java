package bst;

import java.util.Scanner;


class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}
}

public class BSTToSortedLL {
	
	public static HeadTail<LinkedListNode<Integer>> BSTToSortedLLHelper(BinaryTreeNode<Integer> root){
		//base case
		if (root == null) {
			HeadTail<LinkedListNode<Integer>> output = new HeadTail<>();
			output.head = null;
			output.tail = null;
			return output;
		}
		
		HeadTail<LinkedListNode<Integer>> leftOutput = BSTToSortedLLHelper(root.left);
		HeadTail<LinkedListNode<Integer>> rightOutput = BSTToSortedLLHelper(root.right);
		
		LinkedListNode<Integer> root1 = new LinkedListNode<>(root.data); //This is the LinkedListNode
		
		if(leftOutput.head == null) {
			leftOutput.head = root1;
			leftOutput.tail = root1;
		} else {
			leftOutput.head.next = root1;
			leftOutput.tail = root1;
		}
		
		if(rightOutput.head == null) {
			rightOutput.head = root1;
			rightOutput.tail = root1;
		}
		
		leftOutput.tail.next = root1;
		root1.next = rightOutput.head;
		rightOutput.tail.next = null;
		
//		System.out.println(root1.data);
//		System.out.println(rightOutput.head.data + ", " + rightOutput.tail.data);
		return leftOutput;
	}
	
	public static LinkedListNode<Integer> BSTLL(BinaryTreeNode<Integer> root){
		//base case
		return inOrder(root, null);
	}
	
	public static LinkedListNode<Integer> inOrder (BinaryTreeNode<Integer> root, LinkedListNode<Integer> answer) {
		//base case
		if (root == null) {
			return null;
		}
				
		inOrder(root.left, answer);
		LinkedListNode<Integer> dataNode = new LinkedListNode<Integer>(root.data);
		inOrder(root.right, answer);	
		return answer;
	}
	
	static Scanner s = new Scanner(System.in);

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
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		LinkedListNode<Integer> ans = BSTLL(root);
		while(ans != null) {
			System.out.print(ans.data + " ");
			ans = ans.next;
		}
	}

}

class HeadTail<T> {

	public T head;
	public T tail;
}
