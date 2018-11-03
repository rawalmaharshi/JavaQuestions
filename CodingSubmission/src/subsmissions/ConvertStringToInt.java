package subsmissions;

import java.util.Scanner;

public class ConvertStringToInt {
	
	private static int convertStringToInt(String input, int index, int powerOfTen, int returnNum){
		// Write your code here

		int digit = input.charAt(index) - '0';
		double mult = Math.pow(10, powerOfTen);
		digit = (int)mult * digit;
		
		//base case
		if(index == 0) {
			returnNum += digit; 
			return returnNum;
		}
		
		returnNum = digit + convertStringToInt(input, index - 1, powerOfTen + 1, returnNum);	
		return returnNum;
	}
	
	public static int convertStringToInt(String input) {
		return convertStringToInt(input, input.length() - 1, 0, 0);
	}
	
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		int convert = convertStringToInt(input);		
		System.out.println("Integer Output: " + convert);
		s.close();
	}

}
