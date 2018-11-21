package dp;

import java.util.Scanner;

public class StairCase {
	
	public static long staircase(int n) {
		long storage[] = new long[n+1];
		storage[0] = 1;
		if (n >= 1) {
			storage[1] = 1;
		}
		for (int i = 2; i <= n; i++) {
			long possibleSteps = 0;
			possibleSteps += storage[i - 1];
			if (i >= 2) {
				possibleSteps += storage[i-2];
			}
			if (i >=3) {
				possibleSteps += storage[i-3];
			}
			
			storage[i] = possibleSteps;
		}
		return storage[n];
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(staircase(n));
		s.close();
	}

}
