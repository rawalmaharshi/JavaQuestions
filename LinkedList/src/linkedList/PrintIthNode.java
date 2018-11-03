package linkedList;

import java.util.Scanner;

public class PrintIthNode {
	
	public static void printIth(Node<Integer> head, int i){
		
		Node <Integer> temp = head;
		int length = 1;
	      
		while(head.next != null) {
			head = head.next;
			length++;
		}

	    if (i > length) {
	    	return;
	    } else {
	    	head = temp;
	    	while(i > 0) {
	    		if(head.next == null)
	    			return;
    			head = head.next;
	    		i--;
	    	}
	    	System.out.println(head.data);
	    }
		
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
	
	public static void print(Node<Integer> head){
		while(head != null){
			System.out.print(head.data +" ");
			head = head.next;
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		int pos = s.nextInt();
		printIth(head, pos);
	}

}
