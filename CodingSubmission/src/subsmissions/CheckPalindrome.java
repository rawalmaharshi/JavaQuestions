package subsmissions;

import java.util.Scanner;

public class CheckPalindrome {
	
	private static boolean isPalindrome(String input, int startIndex, int endIndex) {
		
		if(input.length() == 0 || input.length() == 1)
			return true;
		
		if(startIndex == endIndex)
			return true;
		
		if(input.charAt(startIndex) != input.charAt(endIndex))
			return false;
		
		if(endIndex < startIndex)
			return true;
		
		return isPalindrome(input, startIndex + 1, endIndex - 1);
	}
	
	
	public static boolean isStringPalindrome(String input) {
		// Write your code here
		return isPalindrome(input, 0, input.length() - 1);
	}
	
	
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		boolean isPalindrome = isStringPalindrome(input);		
		System.out.println("String Palindrome? " + isPalindrome);
		s.close();
	}

}
