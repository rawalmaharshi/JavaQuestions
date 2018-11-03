package linkedList;

import java.util.Scanner;

import linkedList.LinkedListNode;

public class ReverseLLIterative {
	
	public static LinkedListNode<Integer> reverse_I(LinkedListNode<Integer> head) {
		
		LinkedListNode<Integer> prev = null, curr = head, nex = null;
		
		while(curr != null) {
			nex = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nex;
		}
		head = prev;
		return head;
	}
	
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		print(reverse_I(input()));
	}

	public static void print(LinkedListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.getData() + " ");
			head = head.next;
		}
	}

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
}
