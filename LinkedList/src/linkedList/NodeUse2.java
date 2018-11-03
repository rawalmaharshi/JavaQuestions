package linkedList;

import java.util.Scanner;

public class NodeUse2 {
	
	public static Node<Integer> takeInput() {
		
		Node <Integer> head = null, tail = null;
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		
		while (data != -1) {
			Node<Integer> newNode = new Node<Integer>(data);
			
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
//				Node<Integer> temp = head;
//				while (temp.next != null) {
//					temp = temp.next;
//				}
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		s.close();
		return head;
	}
	
	public static void print (Node<Integer> head) {
		
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static Node<Integer> insert (Node <Integer> head, int data, int pos) {
		
		Node<Integer> newNode = new Node<Integer>(data);
		
		if (pos == 0) {
			newNode.next = head;
			return newNode;
		}
		
		int i = 0;
		Node<Integer> temp = head;
		while (i < pos - 1) {
			temp = temp.next;
			i++;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		
		return head;
	}
	
	public static Node<Integer> deleteIthNode(Node<Integer> head, int i){
		int a = 0;
		Node<Integer> temp = head;
		
		if (i == 0) {
			head = temp.next;
			return head;
		}
		while (a < i - 1) {
			temp = temp.next;
			a++;
		}
		if ( temp.next != null) 
			temp.next = temp.next.next;
		return head;
	}

	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
//		head = insert(head, 80, 0);
		head = deleteIthNode(head, 0);
		print(head);
	}

}
