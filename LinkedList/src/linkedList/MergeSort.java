package linkedList;

import java.util.Scanner;

import linkedList.LinkedListNode;

public class MergeSort {
	
	public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
		// write your code here

		if (head == null || head.next == null) {
			return head;
		}
		
		LinkedListNode<Integer> middleNode = getMiddleNode(head);
		LinkedListNode<Integer> middleNodeNext = middleNode.next;
		
		middleNode.next = null;
		
		LinkedListNode<Integer> left = mergeSort(head);
		LinkedListNode<Integer> right = mergeSort(middleNodeNext);
		
		LinkedListNode<Integer> finalList = sortMerge(left, right);
		return finalList;
	
	}

	private static LinkedListNode<Integer> getMiddleNode (LinkedListNode<Integer> head) {
		LinkedListNode<Integer> slow = head, fast = head;
		
		while (fast.next != null && fast.next.next != null) { //for even cases next.next
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;  //Middle Node
	}
	
	private static LinkedListNode<Integer> sortMerge (LinkedListNode<Integer> leftHead, LinkedListNode<Integer> rightHead) {
		
		LinkedListNode<Integer> result = null;
		
		if (leftHead == null) {
			return rightHead;
		}
		
		if (rightHead == null) {
			return leftHead;
		}
		
		if (leftHead.data <= rightHead.data) {
			result = leftHead;
			result.next = sortMerge (leftHead.next, rightHead);
		} else {
			result = rightHead;
			result.next = sortMerge(leftHead, rightHead.next);
		}
		
		return result;
	}
	
	private static Scanner s = new Scanner(System.in);

	public static LinkedListNode<Integer> input() {
		int data = s.nextInt();

		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;
		while (data != -1) {
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}

	public static void print(LinkedListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {

		print(mergeSort(input()));

	}

}
