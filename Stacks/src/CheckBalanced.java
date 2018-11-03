import java.util.Scanner;

class Stack<T> {
	
	private Node<T> head;
	private int size;
		
	public Stack() {
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

public class CheckBalanced {
	
	public static boolean checkBalanced(String ip) throws StackEmptyException {
		Stack<Character> s = new Stack<>();

		for (int i = 0; i < ip.length(); i++) {
			if (ip.charAt(i) == '(' || ip.charAt(i) == '[' || ip.charAt(i) == '{') {
				s.push(ip.charAt(i));
			}
			
			else if (ip.charAt(i) == ')' && s.top() == '(') {
				s.pop();
			}
			
			else if (ip.charAt(i) == ']' && s.top() == '[') {
				s.pop();
			}
			
			else if(ip.charAt(i) == '}' && s.top() == '{') {
				s.pop();
			}
			
			else {
				continue;
			}
		}
		
		if (s.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws StackEmptyException {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(checkBalanced(input));
		s.close();
	}

}
