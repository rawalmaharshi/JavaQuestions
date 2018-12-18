package dp;

import java.util.Scanner;

public class AllPossibleWays {
	
	public static int allWays(int a, int b) {
		return allWays(a, b, 1);
	}

	private static int allWays(int a, int b, int i) {
		//base case
		if (a - (int) Math.pow(i, b) == 0) {
			return 1;
		}
		
		if (a - (int) Math.pow(i, b) <= 0) {
			return 0;
		}
			
		
		return allWays(a,b,i + 1) + allWays(a - (int) Math.pow(i, b), b, i+1);
	}
	
	public static int allWaysM(int a, int b) {
		int storage[] = new int[a + 1];
		for (int i = 0; i < storage.length; i++) {
			storage[i] = -1;
		}
		return allWaysM(a, b, 1, storage);
	}
	
	private static int allWaysM(int a, int b, int i, int[] storage) {
		//base case
		if (a - (int) Math.pow(i, b) == 0) {
			storage[i] = 1;
			return storage[i];
		}
		
		if (a - (int) Math.pow(i, b) <= 0) {
			storage[i] = 0;
			return storage[i];
		}
		
		if (storage[i] != -1) {
			return storage[i];
		}
		
		storage[i] = allWaysM(a,b,i + 1, storage) + allWaysM(a - (int) Math.pow(i, b), b, i+1, storage);
		return storage[i];
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int n = s.nextInt();
		System.out.println(allWaysM(x, n));
		s.close();
	}

}
