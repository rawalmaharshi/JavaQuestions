package linkedList;

import java.util.Scanner;

import linkedList.LinkedListNode;

public class PrintReverseRecursive {
	
	public static void printReverseRecursive (LinkedListNode<Integer> head) {
		
		//base case
		if (head.next == null) {
			System.out.print(head.data + " ");
			return;
		}
		
		printReverseRecursive(head.next);
		System.out.print(head.data + " ");
		
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
	
	private static Scanner s= new Scanner(System.in);
	public static void main(String[] args) {
		printReverseRecursive(input());
	}

}
