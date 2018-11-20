package priority_queues;

import java.util.ArrayList;

public class Priority_Queue {
	
	private ArrayList<Integer> heap;
	
	public Priority_Queue() {
		heap = new ArrayList<>();
	}
	
	boolean isEmpty() {
		return heap.size() == 0;
	}
	
	int size() {
		return heap.size();
	}
	
	int getMin() throws PriorityQueueException {
		if (isEmpty()) {
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}
	
	void insert (int element) {
		heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;
		
		while (childIndex > 0) {
			if (heap.get(childIndex) < heap.get(parentIndex)) {
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
	
	int removeMin() throws PriorityQueueException {
		if (isEmpty()) {
			throw new PriorityQueueException();
		}
		
		int element = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		
		int parentIndex = 0;
		int minIndex = parentIndex;
		int child1Index = 2 * parentIndex + 1;
		int child2Index = 2 * parentIndex + 2;
		while(child1Index < heap.size()) {
			if (heap.get(child1Index) < heap.get(minIndex)) {
				minIndex = child1Index;
			} 
			
			if (child2Index < heap.size() && heap.get(child2Index) < heap.get(minIndex)) {
				minIndex = child2Index;
			}
			
			if (minIndex == parentIndex) {
				break;
			} else {
				int temp = heap.get(parentIndex);
				heap.set(parentIndex, heap.get(minIndex));
				heap.set(minIndex, temp);
				parentIndex = minIndex;
				child1Index = 2 * parentIndex + 1;
				child2Index = 2 * parentIndex + 1;
			}	
		}
		
		return element;
	}
}
