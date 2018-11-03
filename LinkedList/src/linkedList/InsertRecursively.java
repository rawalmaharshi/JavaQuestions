package linkedList;

import java.util.Scanner;

public class InsertRecursively {
	
	public static LinkedListNode<Integer> insertRecursively (LinkedListNode<Integer> head, int pos, int elem) {
		//base case
		if (pos == 0) {
			LinkedListNode<Integer> newNode = new LinkedListNode<>(elem);
			newNode.next = head;
			return newNode;
		}
		
		if (head == null) {
			return head;
		}
		
		head.next = insertRecursively(head.next, pos - 1, elem);
		return head;
		
	}
	
	private static Scanner s = new Scanner(System.in);

	public static LinkedListNode<Integer> input() {
		int data = s.nextInt();
		
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;
		while (data!=-1) {
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
			System.out.print(head.getData() + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		LinkedListNode<Integer> head = input();
		print(insertRecursively(head, 3, 7));
	}
}
