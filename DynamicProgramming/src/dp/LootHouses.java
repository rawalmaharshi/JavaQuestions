package dp;

import java.util.Scanner;

public class LootHouses {

	public static int getMaxMoney(int arr[], int n) {
		return getMaxMoney(arr, n, 0, 0);
	}

	private static int getMaxMoney(int input[], int n, int currIndex, int maxMoney) {
		// base case
		if (currIndex >= n) {
			return 0;
		}

		// Not including money from currIndex
		int option1 = getMaxMoney(input, n, currIndex + 1, maxMoney);
		int option2 = input[currIndex] + getMaxMoney(input, n, currIndex + 2, maxMoney);

		return Math.max(option1, option2);
	}

	public static int getMaxMoneyDP(int input[], int n) {
		int[] storage = new int[n + 1];
		storage[0] = input[0];
		storage[1] = (input[0] > input[1]) ? input[0] : input[1];
		
		for (int i = 2; i < n; i++) {
			storage[i] = Math.max(input[i] + storage[i-2], storage[i-1]);
		}
		return storage[n-1];
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		System.out.println(getMaxMoneyDP(arr, n));
		System.out.println(getMaxMoney(arr, n));
		s.close();
	}
}
