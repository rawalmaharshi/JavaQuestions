package subsmissions;

import java.util.Scanner;

public class ReplacePi {
	
	private static String replace (String input, String output, int ipIndex) {
					
		if(input.charAt(ipIndex) == 'p' && ipIndex != input.length() - 1 && input.charAt(ipIndex + 1) == 'i') {
			output += "3.14";
			if(ipIndex < input.length() - 1)
				ipIndex++;
		} else {
			output += input.charAt(ipIndex);
		}
		
		if(ipIndex == input.length() - 1) {
			return output;
		}
		
		return replace(input, output, ipIndex + 1);
	}
	
	public static String replace(String ip){
		String op = new String("");
		return replace(ip, op, 0);
	}
	
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		String replacePi = replace(input);		
		System.out.println("Final String: " + replacePi);
		s.close();
	}
}
