package subsmissions;

public class PrintKeypad {
	
	private static char[] returnAlphabets (int n) {
		
		switch(n) {
		case 2: char [] alphabets2 = {'a', 'b', 'c'};
				return alphabets2;
		case 3: char [] alphabets3 = {'d', 'e', 'f'};
				return alphabets3;
		case 4: char [] alphabets4 = {'g', 'h', 'i'};
				return alphabets4;
		case 5: char [] alphabets5 = {'j', 'k', 'l'};
				return alphabets5;
		case 6: char [] alphabets6 = {'m', 'n', 'o'};
				return alphabets6;
		case 7: char [] alphabets7 = {'p', 'q', 'r', 's'};
				return alphabets7;
		case 8: char [] alphabets8 = {'t', 'u', 'v'};
				return alphabets8;
		case 9: char [] alphabets9 = {'w', 'x', 'y', 'z'};
				return alphabets9;
		default: char [] alphabets = {};
				 return alphabets;
		}
	}
	
	private static void printKeypad (int input, String outputSoFar) {
		
		//base case
		if (input == 0) {
			System.out.println(outputSoFar);
			return;
		}
		
		int currentDigit = input % 10;
		char [] alphabets = returnAlphabets(currentDigit);
		
		for (int i = 0; i < alphabets.length; i++) {
			printKeypad(input/10, alphabets[i] + outputSoFar);
		}
	}
	
	public static void printKeypad (int input) {
		printKeypad(input, "");
	}

	public static void main(String[] args) {
		printKeypad(235);

	}

}
