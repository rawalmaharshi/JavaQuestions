package linkedList;

import java.util.Scanner;

import linkedList.LinkedListNode;

public class PrintMiddle {
	
	public static int printMiddle(LinkedListNode<Integer> head) {
		
		LinkedListNode<Integer> slow = head, fast = head;
		
		while (fast.next != null && fast.next.next != null) { //for even cases next.next
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow.data;
	}
	
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(printMiddle(input()) + "");
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
