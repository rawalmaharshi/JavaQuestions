import java.util.Scanner;
import java.util.Stack;

public class CountBracketReversals {
	
	public static int countBracketReversals(String input){
		if( input.length() % 2 == 1) {
			return -1;
		} 
		
		int count = 0;
		Stack<Character> s = new Stack<>();
		
		for (int i = 0 ; i < input.length(); i++) {
			if ( input.charAt(i) == '{') {
				s.push(input.charAt(i));
			} else if ( input.charAt(i) == '}' && s.empty()) {
				s.push(input.charAt(i));
			} else if ( input.charAt(i) == '}' && !s.empty() && s.peek() == '{') {
				s.pop();
			} else if ( input.charAt(i) == '}' && !s.empty() && s.peek() != '{') {
				s.push(input.charAt(i));
			}
		}
		
		while (!s.empty()) {
			char c1 = s.pop();
			char c2 = s.pop();
			
			if (c1 == c2) {
				count += 1;
			} else {
				count += 2;
			}
		}
		return count;
	}

	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {

		String str = s.nextLine();
		System.out.println(countBracketReversals(str));

	}
}
