package dp;

import java.util.Scanner;

public class AllPossibleWays {

	private static int allWays(int a, int b, int i, int ways) {
		// base case
		if (a == 0) {
			ways++;
		}
		
		for (i = i + 1; i < a; i++) {
			int diff = (int) (a - Math.pow(i, b));
			if (diff >= 0) {
				allWays(diff, b, i, ways);
			}
		}
		return ways;
	}

	public static int allWays(int a, int b) {
		return allWays(a, b, 0, 0);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int n = s.nextInt();
		System.out.println(allWays(x, n));
		s.close();
	}

}
