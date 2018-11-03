package linkedList;

import java.util.Scanner;

import linkedList.LinkedListNode;

public class PalindromeCheck {
	
	public static boolean isPalindrome_2(LinkedListNode<Integer> head) {
		  LinkedListNode<Integer> temp = head;
		  int length = 1;
		 
		  while(head.next != null) {
		    head = head.next;
		    length++;
		  }
		  
		  int mid = 0;
		  if (length % 2 == 0)
			  mid = length/2 - 1;
		  else
			  mid = length/2;
		  int i = 0;
		  
		  head = temp;
		  
		  while (i < mid) {
			  temp = temp.next;
			  i++;
		  }
		  LinkedListNode <Integer> head2 = temp.next;
	    
		//Reverse second part of the linked list
		LinkedListNode<Integer> prev = null, curr = head2, nex = null;
		while (curr != null) {
			nex = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nex;
		}
		head2 = prev;
		
		while ( head != null && head2 != null) {
			if (head.data.equals(head2.data)) {
				head = head.next;
				head2 = head2.next;
			} else {
				return false;
			}
		}
		return true;
	}
	
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print(isPalindrome_2(input()));
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
