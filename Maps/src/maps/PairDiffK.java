package maps;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class PairDiffK {

	public static void findPairsDifferenceK(int[] input, int k){
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			if (!map.containsKey(input[i])) {
				map.put(input[i], 1);
			} else {
				int currVal = map.get(input[i]);
				map.put(input[i], currVal + 1);
			}
		}
		
		Set<Integer> keys = map.keySet();		
		for (int key : keys) {
			if (map.containsKey(key + k)) {
//				System.out.println(key + ", " + (key + k));
				int noOfFirstElement = map.get(key);
				int noOfSecondElement = map.get(key + k);
				if (noOfFirstElement != input.length) {
					int totalPairs = noOfFirstElement * noOfSecondElement;
					while (totalPairs != 0) {
						System.out.println(key + " " + (key + k));
						totalPairs--;
					}
				} else {
					int totalPairs = fact(input.length - 1);
					while (totalPairs != 0) {
						System.out.println(key + " " + (key + k));
						totalPairs--;
					}
				}
			}
		}
	}
	
	private static int fact(int ip) {
		//base case
		if (ip == 1) {
			return 1;
		}
		
		int fact = ip * fact(ip - 1);
		return fact;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		int k = s.nextInt();
		findPairsDifferenceK(input, k);
		s.close();
	}
}
