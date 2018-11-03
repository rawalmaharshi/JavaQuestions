package linkedList;

import java.util.Scanner;

import linkedList.LinkedListNode;

public class Merging {
	
	public static LinkedListNode<Integer> mergeTwoList(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) { 
		
		if (head1 == null) {
			return head2;
		}
		
		if (head2 == null) {
			return head1;
		}
		
		LinkedListNode<Integer> t1 = head1, t2 = head2, head = null, tail = null;
		
		if (t1.data <= t2.data) {
			head = t1;
			tail = t1;
			t1 = t1.next;
		} else {
			head = t2;
			tail = t2;
			t2 = t2.next;
		}
		
		while ( t1 != null && t2 != null ) {
			if( t1.data <= t2.data) {
				tail.next = t1;
				tail = t1;
				t1 = t1.next;
			} else {
				tail.next = t2;
				tail = t2;
				t2 = t2.next;
			}
		}
		
		if (t1 != null) {
			tail.next = t1;
		} else {
			tail.next = t2;
		}
		
		return head;
	}
	
	static Scanner s = new Scanner(System.in);
	
	public static LinkedListNode<Integer> takeInput() {
		LinkedListNode<Integer> head = null, tail = null;
		int data = s.nextInt();
		while(data != -1) {
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			}
			else {
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}
	
	public static void print(LinkedListNode<Integer> head){
		while(head != null){
			System.out.print(head.data +" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LinkedListNode<Integer> head1 = takeInput();
		LinkedListNode<Integer> head2 = takeInput();
		LinkedListNode<Integer> head3 = mergeTwoList(head1, head2);
		print(head3);
	}
}
