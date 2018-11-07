
public class QueueUsingLL<T> {
	
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
