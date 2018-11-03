package subsmissions;

import java.util.Scanner;

public class SumOfDigits {

	private static int sumOfDigits(int input, int sum){
		// Write your code here
		if(input <= 0) 
			return 0;
		
		int digit = input % 10;
		input = input/10;
		
		sum += digit + sumOfDigits(input, sum);
		return sum;
	}
	
	private static int sumOfDigits(int input){
		return sumOfDigits(input, 0);
	}
	
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int ans = sumOfDigits(n);
		System.out.println("Sum of digits in input: " + ans);
		s.close();
	}
	
}
