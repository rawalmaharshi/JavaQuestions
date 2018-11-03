package subsmissions;

import java.util.Scanner;

public class AddStars {
	
	private static String addStars (String ip, int ipIndex, String op, int opIndex) {
		
		if(ipIndex == ip.length() - 1) {
			op += ip.charAt(ipIndex);
			return op;
		}
		
		if(ip.charAt(ipIndex) == ip.charAt(ipIndex + 1)) {
			op += ip.charAt(ipIndex) + "*";
		} else {
			op += ip.charAt(ipIndex);
		}
		
		return addStars(ip, ipIndex + 1, op, opIndex + 1);
	}
	
	public static String addStars(String s) {
		// Write your code here
		String op = new String("");
		return addStars(s, 0, op, 0);
	}
	
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		String addStars = addStars(input);		
		System.out.println("Final String: " + addStars);
		s.close();
	}

}
