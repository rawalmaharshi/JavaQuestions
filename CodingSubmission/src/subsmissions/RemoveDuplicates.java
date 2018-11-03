package subsmissions;

import java.util.Scanner;

public class RemoveDuplicates {
	
	private static String removeConsecutiveDuplicates (String ip, String op) {
		
		if(ip.length() == 0) {
			return op;
		}
		
		if(op.length() > 1 && op.charAt(op.length() - 1) == ip.charAt(0)) {
			return removeConsecutiveDuplicates(ip.substring(1), op);
		}
		
		if(ip.length() > 1 && ip.charAt(0) == ip.charAt(1)) {
			op += ip.charAt(0);
			return removeConsecutiveDuplicates(ip.substring(2), op);
		} else {
			op += ip.charAt(0);
			return removeConsecutiveDuplicates(ip.substring(1), op);
		}	
	}
	
	public static String removeConsecutiveDuplicates (String s) {
		String op = new String("");
		return removeConsecutiveDuplicates(s, op);
	}

	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		String removeDuplicates = removeConsecutiveDuplicates(input);
		System.out.println("Final String: " + removeDuplicates);
		s.close();
	}
}
