package dp;

import java.util.Scanner;

public class ShortestSubsequence {
	
	public static int solve (String S, String V) {
		return solve (S, V, S.length(), V.length());
	}

	private static int solve(String S, String V, int SLength, int VLength) {
		if (SLength == 0 ) {
			return Integer.MAX_VALUE - 1;
		}
		
		if (VLength == 0) {
			return 1;
		}
		
		int i = 0;
		for (i = 0; i < VLength; i++) {
			if (V.charAt(i) == S.charAt(0)) {
				break;
			}
		}
		
		if (i == VLength) {
			return 1;
		}
		
		return Math.min(solve(S.substring(1), V, SLength - 1, VLength), 1 + solve(S.substring(1), V.substring(i+1), SLength - 1, VLength - i -1));
	}
	
	public static int solveDP (String S, String V) {
		int m = S.length();
		int n = V.length();
		int storage[][] = new int[m+1][n+1];
		
		//V is empty
		for (int i = 0; i <=m; i++) {
			storage[i][0] = 1;
		}
		
		//S is empty
		for (int i = 0; i <=n; i++) {
			storage[0][i] = Integer.MAX_VALUE - 1;
		}
		
		for (int i = 1; i <=m; i++) {
			for (int j = 1; j <=n; j++) {
				char c = S.charAt(i-1);
				int k = 0;
				for (k = j - 1; k >=0; k--) {
					if (V.charAt(k) == c) {
						break;
					}
				}
				
				if (k == -1) {
					storage[i][j] = 1;
				} else {
					storage[i][j] = Math.min(storage[i -1][j], 1 + storage[i-1][k]);
				}
			}
		}
		
		return storage[m][n];
	}

	public static void main(String[] args) {
		String S, V;
		Scanner scan = new Scanner(System.in);

		S = scan.next();
		V = scan.next();
		System.out.println(solveDP(S, V));
		scan.close();
	}
}
