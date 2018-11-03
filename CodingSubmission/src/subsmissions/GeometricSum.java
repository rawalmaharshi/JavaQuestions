package subsmissions;

import java.util.Scanner;

public class GeometricSum {
	public static double findGeometricSum(int k){
		// Write your code here
		
		//base case
		if (k == 0)
			return 1;
		
		
		double denominator = Math.pow(2, k);
		double sum = 1/denominator;
		sum = sum + findGeometricSum(k - 1);
		return sum;
	}
	
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		double ans = 0;
		ans = findGeometricSum(k);
//		System.out.println("Geometric Sum: " + ans);
		System.out.printf("Geometric Sum: %.5f", ans);
		s.close();
	}
}
