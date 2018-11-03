package subsmissions;

public class Keypad {

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
	
	public static String[] keypad (int n, int ansArrayIndex) {
		//base case
		if (n == 0) {
			String [] ans = {""};
			return ans;
		}
		
		int currentDigit = n % 10;
		char [] alphabets = returnAlphabets (currentDigit);
	    
		String[] smallAns = keypad(n/10, ansArrayIndex);
		String[] ans = new String [smallAns.length * alphabets.length];
		
		for (int i = 0; i <smallAns.length; i++) {
			for (int j = 0; j < alphabets.length; j++) {
				ans[ansArrayIndex] = smallAns[i] + alphabets[j];
				ansArrayIndex++;
			}
		}
		
		return ans;
	}
	
	public static void main (String[] args) {
		String[] ans = keypad(234, 0);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
	
}
