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
		
		if (leftOutput == null && rightOutput == null) {
			HeadTail<LinkedListNode<Integer>> output = new HeadTail<>();
			output.head = root1;
			output.tail = root1;
			return output;
		} else {
			HeadTail<LinkedListNode<Integer>> output = new HeadTail<>();
			output.tail.next = root1;
			return output;
		}
	}
	
	public static LinkedListNode<Integer> BSTLL(BinaryTreeNode<Integer> root){
		//base case
		return BSTToSortedLLHelper(root).head;
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
