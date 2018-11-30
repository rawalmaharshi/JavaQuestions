package dp;

import java.util.Scanner;

public class WaysToMakeChange {

	private static int countWaysHelper(int denominations[], int value, int count) {
		// base case		
		if (value == 0) {
			return 1;
		}

		for (int i = 0; i < denominations.length; i++) {	
			if (denominations[i] <= value) {
				count += countWaysHelper(denominations, value - denominations[i], count);
			}
		}
		return count;
	}

	public static int countWaysToMakeChange(int denominations[], int value) {
		return countWaysHelper(denominations, value, 0);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numDenominations = s.nextInt();
		int denominations[] = new int[numDenominations];
		for (int i = 0; i < numDenominations; i++) {
			denominations[i] = s.nextInt();
		}

		int value = s.nextInt();

		System.out.println(countWaysToMakeChange(denominations, value));
		s.close();
	}

}
