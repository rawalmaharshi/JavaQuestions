package linkedList;

import java.util.Scanner;

class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.setData(data);
		this.next = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}

public class ListAppend {
	
	public static LinkedListNode<Integer> append(LinkedListNode<Integer> root, int n) {
	      
	      LinkedListNode<Integer> temp = root;
	      
	      int length = 1;
	      while (temp.next != null) {
	        temp = temp.next;
	        length++;
	      }
	      temp = root;
	      int pos = length - n, i = 0;
	      
	      while ( i < pos - 1) {
	        temp = temp.next;
	        i++;
	      }
	      LinkedListNode<Integer> temp1 = temp.next;
	      temp.next = null;
	      LinkedListNode<Integer> temp2 = root;

	      root = temp1;
	      while(temp1.next != null) {
	    	  temp1 = temp1.next;
	      }
	      temp1.next = temp2;
	 
	      return root;
	}
	
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		print(append(input(), s.nextInt()));
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

	public static void print(LinkedListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.getData() + " ");
			head = head.next;
		}
	}

}
