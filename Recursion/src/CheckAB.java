import java.util.Scanner;

public class CheckAB {
	
	private static boolean checkAB (String input, int index) {
		
		if (input.charAt(0) != 'a') {
			return false;
		}
		
		if (index >= input.length()) {
			return true;
		}
		
		if(input.charAt(index) == 'a') {
			if (index == input.length() - 1)
				return true;
			else if (index == input.length() - 2 && input.charAt(index + 1) == 'a') 
				return true;
			else if (index == input.length() - 3 && input.charAt(index + 1)  == 'b' && input.charAt(index + 2) == 'b') 
				return true;
			else if (index == input.length() - 3 && input.charAt(index + 1)  == 'b' && input.charAt(index + 2) != 'b') 
				return false;
		} 
		
		if (input.charAt(index) == 'b') {
			if (index == input.length() - 2 && input.charAt(index + 1) == 'b') 
				return true;
			else if (index == input.length() - 1) 
				return true;
			else if (index <= input.length() - 3 && input.charAt(index + 1) == 'b' && input.charAt(index + 2) != 'a') 
				return false;
		} 
		
		return checkAB(input, index + 1);
	}
	
	public static boolean checkAB(String input) {
		// Write your code here
		
		return checkAB(input, 0);
	}

	
	public static void main (String [] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		System.out.println(checkAB(input));
		s.close();
	}
}
