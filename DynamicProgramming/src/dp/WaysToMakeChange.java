package dp;

import java.util.Scanner;

public class WaysToMakeChange {

	private static int countWaysHelper(int denominations[], int value, int i) {
		// base case		
		if (i <= 0 && value >= 1) {
			return 0;
		}
		
		if (value == 0) {
			return 1;
		}
		
		if (value < 0) {
			return 0;
		}

		int option1 = countWaysHelper(denominations, value - denominations[i-1], i);
		int option2 = countWaysHelper(denominations, value, i-1);
		
		return option1 + option2;
	}

	public static int countWaysToMakeChange(int denominations[], int value) {
		return countWaysHelper(denominations, value, denominations.length);
	}
	
	public static int countWaysToMakeChangeDP (int denominations[], int value) {
		int storage[] = new int[value + 1];
		storage[0] = 1;
		for (int i = 0; i < denominations.length; i++) {
			for (int j = denominations[i]; j <= value; j++) {
				storage[j] += storage[j - denominations[i]];
			}
		}
		return storage[value];
	}
	
	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numDenominations = s.nextInt();
		int denominations[] = new int[numDenominations];
		for (int i = 0; i < numDenominations; i++) {
			denominations[i] = s.nextInt();
		}

		int value = s.nextInt();

		System.out.println(countWaysToMakeChangeDP(denominations, value));
		s.close();
	}

}
