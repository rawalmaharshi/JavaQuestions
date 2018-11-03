package subsmissions;

import java.util.Scanner;

public class PermutationsPrint {
	
	private static void permutations (String input, String output) {
		// base case
		if(input.length() == 0) {
			System.out.println(output);
			return;
		} 

		for (int i = 0; i < input.length(); i++) {
			String newString1 = input.substring(0, i);
			String newString2 = input.substring(i + 1);
			String finalString = newString1.concat(newString2);
			
			permutations(finalString, output + input.charAt(i));
		}
	}
	
	public static void permutations(String input){
		// Write your code here
		permutations(input, "");
	}
		
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		permutations(input);
		s.close();
	}

}
