package dp;

import java.util.Scanner;

public class LongestIncreasingSubsequence {

	public static int lis(int input[]) {
		int[] storage = new int[input.length];
		for (int i = 0; i < storage.length; i++) {
			storage[i] = 1;			//Every element's sequence is atleast 1
		}

		for (int i = 1; i < storage.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (input[i] > input[j] && storage[i] <= storage[j]) {
					storage[i] = storage[j] + 1;
				}
			}
		}
		int longestSequence = storage[0];
		for (int i = 1; i < storage.length; i++) {
			if (storage[i] > longestSequence) {
				longestSequence = storage[i];
			}
		}
		return longestSequence;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		System.out.println(lis(arr));
		s.close();
	}
}
