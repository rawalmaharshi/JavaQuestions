package maps;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class PairSumToZero {
	
	public static void PairSum(int[] input, int size) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int elem : input) {
			if (!map.containsKey(elem)) {
				map.put(elem, 1);
			} else {
				int value = map.get(elem);
				map.put(elem, value + 1);
			}
		}
		
//		Set<Integer> keys1 = map.keySet();
//		for (Integer key : keys1) {
//			System.out.println(key + ": " + map.get(key));
//		}
		
		//iterate
		Set<Integer> keys = map.keySet();
		for (Integer key : keys) {
			if (key < 0) {
				if (map.containsKey(-1 * key)) {
					int valueOfNegativeKey = map.get(key);
					int valueOfPositiveKey = map.get(-1 * key);
					int totalPairs = valueOfNegativeKey * valueOfPositiveKey;
					while (totalPairs > 0) {
						System.out.println(key + " " + -1 * key);
						totalPairs--;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[]=new int[n];
		for(int i=0; i<n; i++)
		{
			arr[i]=s.nextInt();
		}		
		PairSum(arr, n);
		s.close();
	}
}
