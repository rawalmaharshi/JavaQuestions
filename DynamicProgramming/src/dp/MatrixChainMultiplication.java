package dp;

import java.util.Scanner;

public class MatrixChainMultiplication {

	private static int mcmHelper(int[] input, int sI, int eI) {
		// base case
		if (sI == eI) {
			return 0;
		}

		
		int min = Integer.MAX_VALUE;
		for (int i = sI; i < eI; i++) {
			int ways = mcmHelper(input, sI, i) + mcmHelper(input, i + 1, eI) + input[sI - 1] * input[i] * input[eI];
			if (ways < min) {
				min = ways;
			}
			
		}
//		for (int i = sI; i < eI; i++) {
//			ways = Math.min(ways, mcmHelper(input, sI, i) + mcmHelper(input, i + 1, eI) * input[sI - 1] * input[i] * input[eI]);
//		}
		return min;
	}

	public static int mcm(int[] p) {
		return mcmHelper(p, 1, p.length - 1);
	}
	
	public static int mcmDP (int [] p) {
		int storage[][] = new int [p.length][p.length];
		int q = 0;
		for (int chainL = 2; chainL < p.length; chainL++) {
			for (int i = 0; i < p.length - chainL; i++) {
				int j = i + chainL;
				storage[i][j] = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++) {
					q = storage[i][k] + storage[k][j] + p[i] * p[k] * p[j];
					if (q < storage[i][j]) {
						storage[i][j] = q;
					}
				}
			}
		}
		return storage[0][p.length - 1];
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int p[] = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			p[i] = s.nextInt();
		}
		System.out.println(mcmDP(p));
		s.close();
	}

}
