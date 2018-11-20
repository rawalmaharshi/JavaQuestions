package priority_queues;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxPQ {
	
	private ArrayList<Integer> heap;
	
	public MaxPQ() {
		heap = new ArrayList<>();
	}
	
	public int getSize() {
		return heap.size();
	}
	
	public boolean isEmpty() {
		return heap.size() == 0;
	}
	
	public int getMax() {
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		}
		
		return heap.get(0);
	}
	
	public int getValAtIndex (int i) {
		return heap.get(i);
	}
	
	public void insert(int element) {
		heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;
		
		while (childIndex > 0) {
			if (heap.get(parentIndex) < heap.get(childIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {
				return;
			}
		}
	}
	
	public int removeMax () {
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		}
		
		int element = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		
		int parentIndex = 0;
		int maxIndex = parentIndex;
		int leftChildIndex = 2 * parentIndex + 1;
		int rightChildIndex = 2 * parentIndex + 2;
		
		while (leftChildIndex < heap.size()) {
			if (heap.get(leftChildIndex) > heap.get(maxIndex)) {
				maxIndex = leftChildIndex;
			}
			
			if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(maxIndex)) {
				maxIndex = rightChildIndex;
			}
			
			if (maxIndex == parentIndex) {
				break;
			} else {
				int temp = heap.get(parentIndex);
				heap.set(parentIndex, heap.get(maxIndex));
				heap.set(maxIndex, temp);
				parentIndex = maxIndex;
				leftChildIndex = 2 * parentIndex + 1;
				rightChildIndex = 2 * parentIndex + 1;
			}
		}
		
		return element;
	}
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		MaxPQ pq = new MaxPQ();
//		pq.insert(20);
//		pq.insert(10);
//		pq.insert(15);
//		pq.insert(8);
//		pq.insert(7);
//		pq.insert(11);
//		pq.insert(12);
//		pq.insert(25);
//		pq.removeMax();
//		
//		for (int i = 0 ; i < pq.getSize(); i++) {
//			System.out.println(pq.getValAtIndex(i));
//		}
		
		
		int choice = s.nextInt();
		while(choice != -1) {
			switch(choice) {
				case 1 : // insert
					int element = s.nextInt();
					pq.insert(element);
					break;
				case 2 : // getMax
					System.out.println(pq.getMax());
					break;
				case 3 : // removeMax
					System.out.println(pq.removeMax());
					break;
				case 4 : // size
					System.out.println(pq.getSize());
					break;
				case 5 : // isEmpty
					System.out.println(pq.isEmpty());
				default :
						return;
			}
			choice = s.nextInt();
		}
	}
}
