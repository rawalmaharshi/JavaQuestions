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
	
	public static LinkedListNode<Integer> BSTLL (BinaryTreeNode<Integer> root) {
		//base case
		if (root == null) {
			return null;
		}
		LinkedListNode<Integer> rightHead = null, leftHead = null;
		leftHead = BSTLL(root.left);
		LinkedListNode<Integer> dataNode = new LinkedListNode<Integer>(root.data);
		if (leftHead != null) {
			LinkedListNode<Integer> temp = leftHead;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = dataNode;
		} else {
			leftHead = dataNode;
		}
		
		rightHead = BSTLL(root.right);
		dataNode.next = rightHead;
		
		return leftHead;
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
