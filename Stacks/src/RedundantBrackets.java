import java.util.Scanner;
import java.util.Stack;

public class RedundantBrackets {
	
	public static boolean checkRedundantBrackets(String input) {
		Stack<Character> newStack = new Stack<>();
		
		for (int i = 0; i < input.length(); i++) {
//			System.out.println(i);
			if ( input.charAt(i) == ')') {
				boolean ans = true;
				
				while (newStack.pop() != '(') {
					ans = false;
				}
				
				if (ans == true) {
					return true;
				}
			} else {
				newStack.push(input.charAt(i));
			}
		} 
		return false;
	}
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		String input = s.nextLine();
		System.out.println(checkRedundantBrackets(input));
	}

}
