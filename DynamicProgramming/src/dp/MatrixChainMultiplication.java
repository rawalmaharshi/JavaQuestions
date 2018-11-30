package dp;

import java.util.Scanner;

public class MatrixChainMultiplication {

	private static int mcmHelper(int[] input, int sI, int eI) {
		// base case
		if (sI == eI || sI == (eI - 1)) {
			return 0;
		}

		int ways = 0;
		for (int i = sI; i < eI; i++) {
			ways += mcmHelper(input, sI, i + 1) + mcmHelper(input, i + 1, eI) + input[sI] + input[i] + input[eI];
		}
		return ways;
	}

	public static int mcm(int[] p) {
		return mcmHelper(p, 0, p.length - 1);
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int p[] = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			p[i] = s.nextInt();
		}
		System.out.println(mcm(p));
		s.close();
	}

}
