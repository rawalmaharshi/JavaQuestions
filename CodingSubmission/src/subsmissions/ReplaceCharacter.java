package subsmissions;

import java.util.Scanner;

public class ReplaceCharacter {
	
	private static String replace (String ip, String op, char c1, char c2) {
		
		//base case
		if(ip.length() == 0) {
			return op;
		}
		
		if(ip.charAt(0) == c1) {
			op += c2;
		} else {
			op += ip.charAt(0);
		}
		
		return replace(ip.substring(1), op, c1, c2);
	}

	public static String replace(String ip, char c1, char c2){
		String op = new String("");
		return replace (ip, op, c1, c2);
	}
	
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		char c1 = s.next().charAt(0);
		char c2 = s.next().charAt(0);	
		String replace = replace(input, c1, c2);
		System.out.println("Final String: " + replace);
		s.close();
	}
}
