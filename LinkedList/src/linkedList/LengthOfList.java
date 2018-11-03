package linkedList;

import java.util.Scanner;

public class LengthOfList {
	
	public static int length(Node<Integer> head){

      int length = 1;
      
      while(head.next != null) {
        head = head.next;
        length++;
      }
      
      return length;
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
		System.out.println(head);
		System.out.println(length(head));
	}

}
