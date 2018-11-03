package subsmissions;

import java.util.Scanner;

public class CountZeros {

	private static int countZerosRec(int input, int zeroCount){
		// Write your code here
		if(input <= 0) 
			return 0;
		
		int digit = input % 10;
		
		if(digit == 0)
			zeroCount++ ;
		
		if (input >= 10) {
			input = input/10;
		} else {
			return zeroCount;
		}
			
		int ans = countZerosRec(input, zeroCount);
		return ans;
		
	}
	private static int countZerosRec(int input){
		return countZerosRec(input, 0);
	}
	
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int ans = 0;
		ans = countZerosRec(n);
		System.out.println("No. of zeros in input: " + ans);
		s.close();
	}
}
