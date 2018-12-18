package dp;

import java.util.Scanner;

public class Knapsack01 {

	public static int knapsack(int[] weight, int value[], int maxWeight, int n) {
		return knapsack(weight, value, maxWeight, n, 0, 0);
	}

	private static int knapsack(int[] weight, int[] value, int maxWeight, int n, int currIndex, int currValue) {
		// base case
		if (currIndex >= n || maxWeight == 0) {
			return currValue;
		}

		if (weight[currIndex] > maxWeight) {
			return knapsack(weight, value, maxWeight, n, currIndex + 1, currValue);
		} else {
			// include the current value
			int option1 = knapsack(weight, value, maxWeight - weight[currIndex], n, currIndex + 1,
					currValue + value[currIndex]);
			// exclude
			int option2 = knapsack(weight, value, maxWeight, n, currIndex + 1, currValue);
			return Math.max(option1, option2);
		}
	}

	public static int knapsackM(int[] weight, int value[], int maxWeight, int n) {
		int[] storage = new int[n];
		for (int i = 0; i < storage.length; i++) {
			storage[i] = -1;
		}
		return knapsackM(weight, value, maxWeight, n, 0, 0, storage);
	}

	private static int knapsackM(int[] weight, int[] value, int maxWeight, int n, int currIndex, int currValue,
			int[] storage) {
		// base case
		if (currIndex == n || maxWeight == 0) {
			return currValue;
		}

		if (storage[currIndex] != -1) {
			return storage[currIndex];
		}

		if (weight[currIndex] > maxWeight) {
			storage[currIndex] = 0;
			knapsackM(weight, value, maxWeight, n, currIndex + 1, currValue, storage);
		} else {
			// include the current value
			int option1 = knapsackM(weight, value, maxWeight - weight[currIndex], n, currIndex + 1,
					currValue + value[currIndex], storage);
			// exclude
			int option2 = knapsackM(weight, value, maxWeight, n, currIndex + 1, currValue, storage);
			storage[currIndex] = Math.max(option1, option2);
		}

		return storage[n - 1];
	}

	public static int knapsackDP(int[] weight, int value[], int maxWeight, int n) {
		int[][] storage = new int[n + 1][maxWeight + 1];
		int i, j;

		for (j = 0; j <= maxWeight; j++) {
			storage[0][j] = 0;
		}

		for (i = 0; i <= n; i++) {
			storage[i][0] = 0;
		}

		for (i = 1; i <= n; i++) {
			for (j = 1; j <= maxWeight; j++) {
				if (weight[i - 1] <= j) {
//					storage[i][j] = Math.max((value[i - 1] + storage[i - 1][j - weight[i - 1]]), storage[i - 1][j]);
					storage[i][j] = Math.max(storage[i - 1][j], value[i - 1] + storage[i - 1][j - weight[i - 1]]);
				} else {
					storage[i][j] = storage[i - 1][j];
				}
			}
		}
		return storage[n][maxWeight];
	}

	public static int knapsackDPOptimal(int[] weight, int value[], int maxWeight, int n) {
		int storage[] = new int[maxWeight + 1];

		for (int i = 0; i < n; i++) {
			for (int j = maxWeight; j >= weight[i]; j--) {
				storage[j] = Math.max(storage[j], value[i] + storage[j - weight[i]]);
//				System.out.println("Value of storage[" + j + "] is: " + storage[j]);
			}
		}

		return storage[maxWeight];
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int weight[] = new int[n];
		for (int i = 0; i < n; i++) {
			weight[i] = s.nextInt();
		}
		int value[] = new int[n];
		for (int i = 0; i < n; i++) {
			value[i] = s.nextInt();
		}
		int maxWeight = s.nextInt();
		System.out.println(knapsackDPOptimal(weight, value, maxWeight, n));
		s.close();
	}

}
