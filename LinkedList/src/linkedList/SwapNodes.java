package linkedList;

import java.util.Scanner;

public class SwapNodes {
	
	public static  LinkedListNode<Integer> swap_nodes_helper(LinkedListNode<Integer> head,int i,int j){
		
		if (head == null || head.next == null) {
			return head;
		}
		
		LinkedListNode<Integer> p1 = null, p2 = null, c1 = null, c2 = null, temp = head;
		
		int length = 1;
	      
	    while(head.next != null) {
	        head = head.next;
	        length++;
	    }
	    
	    head = temp;
		
		if ((i == 0) && (j - i) == 1) {
			c1 = temp;
			c2 = temp.next;
			
			c1.next = c2.next;
			c2.next = c1;
			head = c2;
		} else if (i == 0) {
				
			c1 = temp;
			while (i < j) {
				p2 = temp;
				c2 = temp.next;
				temp = temp.next;
				i++;
			}
			
			p1 = c1.next;
		
			p2.next = c1;
			c1.next = c2.next;
			c2.next = p1;
			head = c2;
				
		} else if ((j - i) == 1) {
			int a = 0;
			while (a < i) {
				p1 = temp;
				c1 = temp.next;
				temp = temp.next;
				a++;
			}
			while (a < j) {
				c2 = temp.next;
				temp = temp.next;
				a++;
			}
			
			c1.next = c2.next;
			c2.next = c1;
			p1.next = c2;
			
		} else if (j == (length - 1)) { 
			int a = 0;
			while (a < i) {
				p1 = temp;
				c1 = temp.next;
				temp = temp.next;
				a++;
			}
			
			while (a < j) {
				p2 = temp;
				c2 = temp.next;
				temp = temp.next;
				a++;
			}
			LinkedListNode<Integer> temp1 = c1.next;
			p1.next = c2;
			p2.next = c1;
			c1.next = c2.next;
			c2.next = temp1;
			
		} else {
			int a = 0;
			while (a < i) {
				p1 = temp;
				c1 = temp.next;
				temp = temp.next;
				a++;
			}
			while (a < j) {
				p2 = temp;
				c2 = temp.next;
				temp = temp.next;
				a++;
			}
		
			LinkedListNode<Integer> temp1 = c1.next;
			p1.next = c2;
			p2.next = c1;
			c1.next = c2.next;
			c2.next = temp1;
			
		}
		return head;
	}
	
	public static  LinkedListNode<Integer> swap_nodes(LinkedListNode<Integer> head,int i,int j){ 
		if (i <= j) {
			return swap_nodes_helper( head, i, j);
		} else {
			return swap_nodes_helper( head, j, i);
		}
	}
	
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		print(swap_nodes(input(), s.nextInt(), s.nextInt()));
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

// Optimal Solution
//LinkedListNode<Integer> temp = head, prev = null; 
//LinkedListNode<Integer> node1 = null, node2 = null, node1_prev = null, node2_prev = null; 
//int pos = 0; while(temp != null) { if(pos == i) 
//{ node1_prev = prev; node1 = temp; } else if(pos == j) 
//{ node2_prev = prev; node2 = temp; } prev = temp; temp = temp.next; pos++; }
//if(node1_prev != null) { node1_prev.next = node2; } else { head = node2; } 
//if(node2_prev != null) { node2_prev.next = node1; } else { head = node1; } 
//LinkedListNode<Integer> temp1 = node2.next; node2.next = node1.next; node1.next = temp1; return head; }
