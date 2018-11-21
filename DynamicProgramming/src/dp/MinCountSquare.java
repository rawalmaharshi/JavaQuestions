package dp;

import java.util.Scanner;

public class MinCountSquare {

	public static boolean IsPerfectSquare(double input) {
		long closestRoot = (long) Math.sqrt(input);
		return input == closestRoot * closestRoot;
	}

	private static int minCount(double n, int minAnswer) {
		// base case
		if (n <= 3) {
			return (int) n;
		}
		
		if (IsPerfectSquare(n)) {
			int option1 = minCount(Math.sqrt(n), minAnswer + 1);
//			System.out.println(option1);
			minAnswer = option1;
		} else {
			int option2 = minCount((n - 1), minAnswer + 1);
			if (option2 <= minAnswer) {
				minAnswer = option2;
			}
		}

		return minAnswer;
	}

	public static int minCount1(int n) {
		double ip = n;
		return minCount(ip, 0);
	}
	
	public static int minCount (int n) {
		//base case
		if (n <= 3) {
			return n;
		}
		
		int res = n;
		
		for (int i = 1; i <= n; i++) {
			int tempSquare = i*i;
			if (tempSquare > n) {
				break;
			} else {
				res = Math.min(res, 1 + minCount(n - tempSquare));
			}
		}
		return res;
	}
	
	public static int minCountDP (int n) {
		int storage[] = new int[n + 1];
		storage[0] = 0;
		storage[1] = 1;
		storage[2] = 2;
		storage[3] = 3;
		
		for (int i = 4; i <= n; i++) {
			storage[i] = i;
			for (int j = 1; j <=i; j++) {
				int tempS = j*j;
				if (tempS > i) {
					break;
				} else {
					storage[i] = Math.min(storage[i], 1 + storage[i - tempS]);
				}
			}
		}
		return storage[n];
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(minCountDP(n));
		System.out.println(minCount(n));
		s.close();
	}

}
