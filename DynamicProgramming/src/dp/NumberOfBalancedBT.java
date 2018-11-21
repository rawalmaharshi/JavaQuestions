package dp;

import java.util.Scanner;

public class NumberOfBalancedBT {
	
	public static int balancedTreesOfHeightH (int height) {
		int mod = (int) Math.pow(10, 9) + 7;
		return balancedTreesOfHeightH(height, mod);
	}
	
	private static int balancedTreesOfHeightH(int height, int mod){
		//base case
		if (height == 0 || height == 1) {
			return 1;
		}
		
		int x = balancedTreesOfHeightH(height - 1);
		int y = balancedTreesOfHeightH(height - 2);
		
		long res1 = (long) x * x;
		long res2 = (long) x * y * 2;
		int value1 = (int) (res1 % mod);
		int value2 = (int) (res2 % mod);
	
		return (value1 + value2) % mod;
	}
	
	public static int balancedTreesOfHeightHDP (int h) {
		int mod = (int) Math.pow(10, 9) + 7;
		int storage[] = new int[h + 1];
		storage[0] = 1;
		if (h >= 1) {
			storage[1] = 1;
		}
		
		for (int i = 2; i <= h; i++) {
			int x = storage[i-1];
			int	y = storage[i-2];
//			System.out.println("x: " + x + " ,y: " + y);
			long res1 = (long) x * x;
			long res2 = (long) x * y * 2;
			int value1 = (int) (res1 % mod);
			int value2 = (int) (res2 % mod);
//			System.out.println("1: " + value1 + " 2: " + value2);
			storage[i] = (value1 + value2) % mod;
		}
		return storage[h];
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int height = s.nextInt();
		System.out.println(balancedTreesOfHeightHDP(height));
		System.out.println(balancedTreesOfHeightH(height));
		s.close();
	}
}
