package linkedList;

import java.util.Scanner;

public class IndexOfNRec {
	
	private static int indexOfNRec (LinkedListNode<Integer> head, int n, int count) {
		//base case
		if(head == null) {
			return -1;
		}
		
		if(head.data == n) {
			return count;
		} 
		
		count++;	
		count = indexOfNRec(head.next, n, count);
		
		return count;
		
	}
	
	public static int indexOfNRec(LinkedListNode<Integer> head, int n) {
		return indexOfNRec(head, n, 0);
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
	

	
	public static void main(String[] args) {
		LinkedListNode<Integer> head = takeInput();
		int n = s.nextInt();
		System.out.println(indexOfNRec(head, n));
	}

}
