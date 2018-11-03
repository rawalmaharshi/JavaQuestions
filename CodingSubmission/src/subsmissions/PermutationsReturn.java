package subsmissions;

import java.util.Scanner;

public class PermutationsReturn {
	
	private static String[] permutationOfString (String input, int outputIndex) {
		//base case
		if (input.length() == 0) {
			String [] ans = {""};
			return ans;
		}
		
		
		for (int i = 0; i < input.length(); i++) {
			String newString1 = input.substring(0, i);
			String newString2 = input.substring(i + 1);
			String finalString = newString1.concat(newString2);
			String [] smallAns = permutationOfString(finalString, outputIndex);
			
		}
		return smallAns;
	}
	
	public static String[] permutationOfString(String input){
		// Write your code here
		return permutationOfString(input, 0);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		String output[] = permutationOfString(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
		s.close();
	}
}
