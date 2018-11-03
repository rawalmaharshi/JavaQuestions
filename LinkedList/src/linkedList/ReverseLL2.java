package linkedList;

import java.util.Scanner;

import linkedList.LinkedListNode;

public class ReverseLL2 {
	
	public static DoubleNode reverseLLBetter (LinkedListNode<Integer> head) {
		
		if (head == null || head.next == null) {
			DoubleNode ans = new DoubleNode();
			ans.head = head;
			ans.tail = head;
			return ans;
		}
		
		DoubleNode smallAns = reverseLLBetter(head.next);
		smallAns.tail.next = head;
		head.next = null;
		
		DoubleNode ans = new DoubleNode();
		ans.head = smallAns.head;
		ans.tail = head;
		return ans;
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
	
	private static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		LinkedListNode<Integer> head = input();
		DoubleNode ans = reverseLLBetter(head);
		print(ans.head);
	}

}

class DoubleNode {
	
	LinkedListNode<Integer> head;
	LinkedListNode<Integer> tail;

}