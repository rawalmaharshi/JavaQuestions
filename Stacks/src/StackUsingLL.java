
public class StackUsingLL<T> {
	
	private Node<T> head;
	private int size;
		
	public StackUsingLL() {
		head = null;
		size = 0;
	}
	
	int size() {
		return size;
	}
	
	T top() throws StackEmptyException {
		if (head == null) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		} 
		
		return head.data;	
	}
	
	boolean isEmpty() {
		return (head == null);
	}
	
	void push(T element) {
		Node<T> newNode = new Node<>(element);
		
		newNode.next = head;
		head = newNode;	
		size++;
	}
	
	T pop() throws StackEmptyException {
		if (head == null) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		} 
		
		Node<T> temp =  head;
		head = head.next;
		
		size--;
		return temp.data;
	}

}
