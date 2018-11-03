package linkedList;

import java.util.Scanner;

import linkedList.LinkedListNode;

public class ReverseLL {
	
	public static LinkedListNode<Integer> reverse_R(LinkedListNode<Integer> head) {
		//base case
		if(head == null || head.next == null) {
			return head;
		}
		
		LinkedListNode<Integer> newHead = reverse_R(head.next);
		LinkedListNode<Integer> temp = newHead;
		
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = head;
		head.next = null;
		
		return newHead;
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
		print(reverse_R(input()));
	}
	public static void print(LinkedListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.getData() + " ");
			head = head.next;
		}
	}
}
