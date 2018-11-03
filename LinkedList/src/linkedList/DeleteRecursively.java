package linkedList;

import java.util.Scanner;

public class DeleteRecursively {
	
	public static LinkedListNode<Integer> deleteIthNodeRec (LinkedListNode<Integer> head, int i) {
		//base case
		
		if (head == null) {
			return head;
		}
		
		if (i == 0) {
			return head.next;
		}
		
		head.next = deleteIthNodeRec(head.next, i - 1);
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
		int pos = s.nextInt();
		head = deleteIthNodeRec(head, pos);
		print(head);
	}
}
