package subsmissions;

import java.util.Scanner;

public class TowerOfHanoi {
	
	private static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
		// Write your code here
		//base case(s)
		if(disks == 0 ) {
			return;
		}
		
		if(disks == 1) {
			System.out.println(source + " " + destination);
			return;
		} else {
			
			towerOfHanoi(disks - 1, source, destination, auxiliary);
			System.out.println(source + " " + destination);
			towerOfHanoi(disks - 1, auxiliary, source, destination);	
		}
		
	}
	
	public static void towerOfHanoi (int n) {
		towerOfHanoi (n, 'a', 'b', 'c');
	}
	
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		towerOfHanoi(n);
		s.close();
	}

}
