package linkedList;

import java.util.Scanner;

public class KReverse {
	
	public static HeadTail smallReverse (LinkedListNode<Integer> head) {
		if (head == null || head.next == null) {
			HeadTail ans = new HeadTail();
			ans.head = head;
			ans.tail = head;
			return ans;
		}
		
		HeadTail smallAns = smallReverse(head.next);
		smallAns.tail.next = head;
		head.next = null;
		
		HeadTail ans = new HeadTail();
		ans.head = smallAns.head;
		ans.tail = head;
		return ans;
	}
	
	public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		LinkedListNode<Integer> head1 = head, tail1 = head, head2 = null;
		int count = 1;
		while (count != k && tail1 != null) {
			tail1 = tail1.next;
			count++;
		}
		if (tail1 != null) {
			head2 = tail1.next;
			tail1.next = null;
				
		}
		HeadTail smallAns = smallReverse(head1);
		head1 = smallAns.head;
		tail1 = smallAns.tail;		

		head2 = kReverse(head2, k);
		tail1.next = head2;
		
		return head1;
	}
	
	static Scanner s = new Scanner(System.in);

	public static void print(LinkedListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.getData() + " ");
			head = head.next;
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
		print(kReverse(input(), s.nextInt()));
	}
}

class HeadTail {
	LinkedListNode<Integer> head;
	LinkedListNode<Integer> tail;
}
