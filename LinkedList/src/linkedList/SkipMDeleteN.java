package linkedList;

import java.util.Scanner;

public class SkipMDeleteN {
	
	public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
		
		LinkedListNode<Integer> temp1 = head, temp2 = null, tail = head;
		int c1 = 1, c2 = 1;
		
		if (M == 0 || N == 0) {
			return null;
		}
	
		while (tail != null) {
			while (c1 < M && temp1 != null) {
				temp1 = temp1.next;
				c1++;
//				tail = tail.next;
			}
			
			if(temp1 != null) {
				temp2 = temp1.next;
			} else {
				temp2 = null;
			}
			
			while (c2 < N && temp2 != null) {
				temp2 = temp2.next;
				c2++;
//				tail = tail.next;
			}
			
			if (temp2 != null) {
				temp2 = temp2.next;
				temp1.next = temp2;
				temp1 = temp2;
//				tail = tail.next;
				c1 = 1;
				c2 = 1;
			} 
			tail = tail.next;
		}

		return head;
		
	}
	
	static Scanner s = new Scanner(System.in);

	public static void print(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.next;
		}
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
	
	public static void main(String[] args) {
		print(skipMdeleteN(input(), s.nextInt(), s.nextInt()));
	}

}
