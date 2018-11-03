package linkedList;

import java.util.Scanner;

public class IndexOfNIter {
	
	public static int indexOfNIter(Node<Integer> head, int n) {
		int pos = 0;
		
		if (n == head.data) {
			return pos;
		}
		
		while (head.next != null) {
			head = head.next;
			pos++;
			if (n == head.data) {
				break;
			}	
		}
		
		if (head.next == null && n != head.data) {
			return -1;
		}
		
		return pos;
	}
	
static Scanner s = new Scanner(System.in);
	
	public static Node<Integer> takeInput() {
		Node<Integer> head = null, tail = null;
		int data = s.nextInt();
		while(data != -1) {
			Node<Integer> newNode = new Node<Integer>(data);
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
		Node<Integer> head = takeInput();
		int n = s.nextInt();
		System.out.println(indexOfNIter(head, n));
	}

}
