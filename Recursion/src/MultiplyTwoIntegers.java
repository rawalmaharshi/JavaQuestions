

import java.util.Scanner;

public class MultiplyTwoIntegers {
	
	public static int multiplyTwoIntegers(int m, int n){
		// Write your code here
		if(m == 0 || n == 0)
			return 0;
		
		if (n == 1) 
			return m;
		
		//Add m 'n' times
		int mul = m + multiplyTwoIntegers(m, n - 1);
		return mul;
	}
	
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int m = Integer.parseInt(s.nextLine());
		int n = Integer.parseInt(s.nextLine());
		int ans = 0;
		if (m >= n)
			 ans = multiplyTwoIntegers(m, n);
		else if (n > m)
			 ans = multiplyTwoIntegers(n, m);
		System.out.println("Multiplication of two integers: " + ans);
		s.close();
	}
	
}
