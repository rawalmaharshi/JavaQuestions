package dp;

import java.util.Scanner;

public class AllPossibleWays {

	public static int allWays(int a, int b) {
		return 1;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int n = s.nextInt();
		System.out.println(allWays(x, n));
		s.close();
	}

}
