package subsmissions;

import java.util.Scanner;

public class CheckAB {
	
	private static boolean checkAB (String input, int ipIndex) {
		
//		//Constraint #1
		if (input.charAt(0) != 'a') {
			return false;
		}
		

		if (input.length() == 1 && input.charAt(0) == 'a') {
			return true;
		}
		
		if(input.charAt(ipIndex) != 'a' && input.charAt(ipIndex) != 'b') {
			return false;
		}
		
		if(ipIndex == input.length() - 1 && (input.charAt(ipIndex) == 'a' || (input.charAt(ipIndex) == 'b' && input.charAt(ipIndex - 1) == 'b'))) {
			return true;
		}
			
//		if( input.charAt(ipIndex) == 'a' && input.charAt(ipIndex + 1) == 'b') {
//			if (ipIndex < input.length() - 2 && input.charAt(ipIndex + 2) == 'b') {
//				return checkAB(input, ipIndex + 2);
//			} else {
//				return false;
//			}
//		} else {
//			return false;
//		}
		return checkAB(input, ipIndex + 1);
		
	}
	
	public static boolean checkAB (String input) {
		return checkAB(input, 0);
	}
	
	
	
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		boolean result = checkAB(input);		
		System.out.println("String AB? " + result);
		s.close();
	}

}
