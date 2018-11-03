package linkedList;

import java.util.Scanner;

public class SortEvenOdd {
	
	public static LinkedListNode<Integer> sortEvenOdd(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> oddH = null, evenH = null, oddT = null, evenT = null;
		
		while (head != null) {
			if (head.data % 2 == 1) { 
				if (oddH == null) {
					oddH = head;
					oddT = head;
				} else {
					oddT.next = head;
					oddT = head;
				}
			} else {
				if (evenH == null) {
					evenH = head;
					evenT = head;
				} else {
					evenT.next = head;
					evenT = head;
				}
			}
			head = head.next;
		}
		
		if (oddT != null) {
			oddT.next = evenH;
		}
		
		if (evenT != null) {
			evenT.next = null;
		}
		
		//Returning updated heads
		
		if (oddH != null) {
			return oddH;
		} else {
			return evenH;
		}
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
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		print(sortEvenOdd(input()));
	}
}
