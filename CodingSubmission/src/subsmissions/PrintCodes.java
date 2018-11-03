package subsmissions;

import java.util.Scanner;

public class PrintCodes {
	
	public static void printAllPossibleCodes(String input, String outputSoFar) {
		//base case
		 if (input.length() == 0) {
	        System.out.println(outputSoFar);
	        return;
		}

	    String ch1 = input.substring(0, 1);
	    String restOfTheString1 = input.substring(1);

	    if (Integer.parseInt(ch1, 10) > 0) {
	        char code = (char) (Integer.parseInt(ch1, 10) + 'a' - 1);
	        printAllPossibleCodes(restOfTheString1, outputSoFar + code);
	    }

	    if (input.length() >= 2) {
	        String ch12 = input.substring(0, 2);
	        String restOfTheString2 = input.substring(2);

	        if (Integer.parseInt(ch12, 10) > 0 && Integer.parseInt(ch12) <= 26) {
	            char code = (char) (Integer.parseInt(ch12, 10) + 'a' - 1);
	            printAllPossibleCodes(restOfTheString2, outputSoFar + code);
	        }
	        if (Integer.parseInt(ch12, 10) == 0) {
	            printAllPossibleCodes(restOfTheString2, outputSoFar);
	        }
	    }
	}
	
	public static void printAllPossibleCodes(String input) {
		// Write your code here
		printAllPossibleCodes(input, "");
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		printAllPossibleCodes(input);
		s.close();
	}
}
