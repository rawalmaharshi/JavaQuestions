package priority_queues;

import java.util.PriorityQueue;
import java.util.Scanner;

class QueueEmptyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

class Node<T> {
	
	T data;
	Node<T> next;
	
	Node (T data) {
		this.data = data;
		next = null;
	}

}

class QueueUsingLL<T> {
	
	private Node<T> front;
	private Node<T> rear;
	int size;

	public QueueUsingLL() {
		front = null;
		rear = null;
		size = 0;
	}
	
	int size() {
		return size;
	}
	
	boolean isEmpty() {
		return (size == 0);
	}
	
	T front() throws QueueEmptyException {
		if (front == null) {
//			return null;
			throw new QueueEmptyException();
		}
		
		return front.data;
	}
	
	void enqueue(T value) {
		Node<T> newNode = new Node<T>(value);
		
		if (rear == null) {
			front = newNode;
			rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
		
		size++;
	}
	
	T dequeue() throws QueueEmptyException {
		if (front == null) {
//			return null;
			throw new QueueEmptyException();
		}
		
		T temp = front.data;
		front = front.next;
		
		if (size == 1) {		//Delete last element
			rear = null;
		}
		size--;
		return temp;
	}
}

public class BuyTicket {
	
	public static int buyTicket(int input[], int k) {
		MaxPQComparator max = new MaxPQComparator();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(max);
		QueueUsingLL<Integer> q = new QueueUsingLL<>();
		
		for (int i = 0; i < input.length; i++) {
			q.enqueue(i);
			maxHeap.add(input[i]);
		}
		
		int time = 0;
		
		try {
			while (!q.isEmpty()) {
				if (input[q.front()] == maxHeap.peek()) {
					time += 1;
					if (q.front() == k) {
						return time;
					}
					q.dequeue();
					maxHeap.remove();
				} else {
					//remove from queue and add at last
					int qElement = q.dequeue();
					q.enqueue(qElement);
				}
			}
		} catch (QueueEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return time;
	}

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		int k = s.nextInt();
		System.out.println(buyTicket(input, k));
	}
}
