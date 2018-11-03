package subsmissions;

import java.util.Scanner;

public class Staircase {
	
	public static int staircase (int n) {
		
		//base case
		if(n == 0) {
			return 1;
		}
		int y=0,z=0;
		int x = staircase(n-1);
		if(n >= 2) {
			y = staircase(n-2);
		}
		if(n >= 3) {
			z = staircase(n-3);
		}
		return x + y + z;
	}
	
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int ans = staircase(n);
		System.out.println("Number of possible ways to climb stairs: " + ans);
		s.close();
	}

}
