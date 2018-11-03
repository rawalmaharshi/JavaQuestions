package linkedList;

import java.util.Scanner;

public class ReverseLL3 {
	
	public static LinkedListNode<Integer> reverseLLR(LinkedListNode<Integer> head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		LinkedListNode <Integer> reversedTail = head.next;
		LinkedListNode <Integer> smallHead = reverseLLR(head.next);
		reversedTail.next = head;
		head.next = null;
		
		return smallHead;
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
	
	private static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		print(reverseLLR(input()));
	}
	public static void print(LinkedListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.getData() + " ");
			head = head.next;
		}
	}

}
