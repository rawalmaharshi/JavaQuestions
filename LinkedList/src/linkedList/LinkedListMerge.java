package linkedList;

import java.util.Scanner;

import linkedList.LinkedListNode;

public class LinkedListMerge {
	
	public static LinkedListNode<Integer> mergeTwoList(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
		
		LinkedListNode<Integer> head = null, tail = null;
		LinkedListNode<Integer> head1NextAddress = head1, head2NextAddress = head2;
		
		if (head1.data < head2.data) {
			head = head1;
		} else {
			head = head2;
		}
		
		while(true) {
			
			if (head1 == null) {
				tail.next = head2;
				break;
			}
			
			if (head2 == null) {
				tail.next = head1;
				break;
			}
			
			if ( head1.data < head2.data ) {
				tail = head1;
				head1NextAddress = tail.next;
				head1 = head1NextAddress;
				if(head1 != null && head2 != null && head2.data < head1.data)
					tail.next = head2;
				else
					tail.next = head1;
				
			} else if ( (head1.data).compareTo(head2.data) == 1 ){
				tail = head2;
				head2NextAddress = tail.next;
				head2 = head2NextAddress;
				if(head1 != null && head2 != null && head1.data < head2.data)
					tail.next = head1;
				else
					tail.next = head2;
				
			} 
		}
		return head;
		
//		if (head1 == null) return head2;
//		  if (head2 == null) return head1;
//
//		  LinkedListNode<Integer> head;
//		  if (head1.data < head2.data) {
//		    head = head1;
//		  } else {
//		    head = head2;
//		    head2 = head1;
//		    head1 = head;
//		  }
//		  while(head1.next != null) {
//		    if (head1.next.data > head2.data) {
//		      LinkedListNode<Integer> tmp = head1.next;
//		      head1.next = head2;
//		      head2 = tmp;
//		    }
//		    head1 = head1.next;
//		  } 
//		  head1.next = head2;
//		  return head;
		
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
