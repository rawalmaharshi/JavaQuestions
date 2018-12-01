package dp;

import java.util.Scanner;

public class CoinTower {

	public static String solve(int n, int x, int y) {
		int[] storage = new int[n + 1];
		storage[1] = 1;
		if (x <= n) {
			storage[x] = 1;
		}
		if (y <= n) {
			storage[y] = 1;
		}

		for (int i = 2; i <= n; i++) {
			if (storage[i] == 1) {
				continue;
			}

			if ((i - x) >= 1 && (i - y) >= 1) {
				int countOfOnes = 0, countOfZeroes = 0;
				if (storage[i - 1] == 1) {
					countOfOnes += 1;
				}
				if (storage[i - x] == 1) {
					countOfOnes += 1;
				}
				if (storage[i - y] == 1) {
					countOfOnes += 1;
				}
				countOfZeroes = 3 - countOfOnes;
//				System.out.println("i: " + i + ", " + countOfOnes + ", " + countOfZeroes);
				storage[i] = countOfZeroes > 0 ? 1 : 0;
//				storage[i] = (storage[i - x]) ^ (storage[i - y]) ^ (storage[i - 1]) ^ 1;
			} else if ((i - x) >= 1) {
				storage[i] = storage[i - x] ^ 1;
			} else if ((i - y) >= 1) {
				storage[i] = storage[i - y] ^ 1;
			} else {
				storage[i] = storage[i - 1] ^ 1;
			}
		}

		if (n == x || n == y) {
			return "Beerus";
		}

		if (storage[n] == 1) {
			return "Beerus";
		} else {
			return "Whis";
		}

	}

	public static void main(String[] args) {

		int x, n, y;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		x = scan.nextInt();
		y = scan.nextInt();
		System.out.println(solve(n, x, y));
		scan.close();
	}

}
