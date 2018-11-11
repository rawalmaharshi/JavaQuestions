package subsmissions;

import java.util.Scanner;

public class GetCode {
	
	public static char getChar(int n){ 
		return (char)(96 + n); 
	} 
	public static String[] getCode(String input) {
		if(input.length() == 0) { 
			String[] output = {""}; 
			return output; 
		}
		
		int firstDigit = (input.charAt(0) - '0'); 
		String[] smallOutput1 = getCode(input.substring(1)); 
		String[] smallOutput2 = new String[0]; 
		int firstTwoDigits = 0; 
		if(input.length() >= 2) { 
			firstTwoDigits = (input.charAt(0) - '0') * 10 + (input.charAt(1) - '0'); 
			if(firstTwoDigits > 10 && firstTwoDigits<=26){ 
				smallOutput2 = getCode(input.substring(2)); 
			} 
		} 
		String output[] = new String[smallOutput1.length + smallOutput2.length]; 
		int k = 0; 
		for(String s : smallOutput1){ 
			char firstDigitChar = getChar(firstDigit); // (char)('a'-1+lastDigit) 
			output[k] = firstDigitChar + s;
			k++; 
		}
		
		for( String s : smallOutput2){ 
			char firstTwoDigitChar = getChar(firstTwoDigits); 
			output[k] = firstTwoDigitChar + s; 
			k++; 
		} 
		return output;	
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();																																																																				
		String output[] = getCode(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
		s.close();
	}
}
