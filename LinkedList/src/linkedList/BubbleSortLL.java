package linkedList;

import java.util.Scanner;

public class BubbleSortLL {
	
	public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head ) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		LinkedListNode<Integer> prev = null, curr = head, nex = null;
		
		int length = 0;
		while ( curr != null) {
			curr = curr.next;
			length++;
		}
		
		for (int i = 0; i < length; i++) {
			prev = null;
			curr = head; //Again point towards the head
			nex = curr.next;
			while (curr.next != null) {
				if ( curr.data  <= nex.data ) {
					prev = curr;
					curr = curr.next;
					nex = nex.next;
				} else {
					if ( prev == null ) {
						curr.next = nex.next;
						nex.next = curr;
						prev = nex;
						head = prev;
						nex = curr.next;
					} else {
						prev.next = curr.next;
						curr.next = nex.next;
						nex.next = curr;
						prev = prev.next;
						nex = curr.next;
					}
				}
			}
		}
		
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
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		print(bubbleSort(input()));
	}
	
}
