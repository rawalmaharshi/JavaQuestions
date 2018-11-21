package dp;

import java.util.Scanner;

public class MinStepsTo1 {

	public static int countStepsTo1(int n) {
		// base case
		if (n == 1) {
			return 0;
		}

		int option1 = countStepsTo1(n- 1);
		int minSteps = option1;
		
		if (n % 3 == 0) {
			int option2 = countStepsTo1(n/3);
			if (option2 < minSteps) {
				minSteps = option2;
			}
		}
		
		if (n % 2 == 0) {
			int option3 = countStepsTo1(n/2);
			if (option3 < minSteps) {
				minSteps = option3;
			}
		}
		return minSteps + 1;
	}
	
	public static int countStepsM (int n) {
		int storage[] = new int[n + 1];
		return countStepsM (n, storage);
	}

	private static int countStepsM(int n, int[] storage) {
		//base case
		if (n == 1) {
			storage[n] = 0;
			return storage[n];
		}
		
		if (storage[n] != 0) {
			return storage[n];
		}
		
		int option1 = countStepsM(n- 1, storage);
		int minSteps = option1;
		
		if (n % 3 == 0) {
			int option2 = countStepsM(n/3, storage);
			if (option2 < minSteps) {
				minSteps = option2;
			}
		}
		
		if (n % 2 == 0) {
			int option3 = countStepsM(n/2, storage);
			if (option3 < minSteps) {
				minSteps = option3;
			}
		}
		storage[n] = minSteps + 1;
		return storage[n];
	}
	
	public static int countStepsDP (int n) {
		int storage[] = new int[n+1];
		storage[1] = 0;
		for (int i = 2; i <=n; i++) {
			int min = storage[i-1];
			if (i % 3 == 0) {
				if (min > storage[i/3]) {
					min = storage[i/3];
				}
			}
			
			if (i % 2 == 0) {
				if (min > storage[i/2]) {
					min = storage[i/2];
				}
			}
			storage[i] = 1 + min;
		}
		return storage[n];
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(countStepsM(n));
		System.out.println(countStepsDP(n));
		System.out.println(countStepsTo1(n));
		s.close();
	}
}
