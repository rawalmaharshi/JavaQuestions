package subsmissions;

import java.util.Scanner;

public class RemoveX {
	
	private static String removeX(String input, String output, int ipIndex){
		// Write your code here
		
		if(input.charAt(ipIndex) != 'x') {
			output += input.charAt(ipIndex);
		}
		
		if(ipIndex == input.length() -1)
			return output;
		
		return removeX(input, output, ipIndex + 1);
			
	}
	
	public static String removeX(String ip) {
		String op = new String("");
		return removeX(ip, op, 0);
	}
	
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		String removeX = removeX(input);		
		System.out.println("Final String: " + removeX);
		s.close();
	}
	

}
