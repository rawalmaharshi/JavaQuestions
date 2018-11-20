package maps;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class MaxFrequencyNumber {
	
	public static int maxFrequencyNumber(int[] arr){
		HashMap<Integer, Integer> answer = new HashMap<>();
		int maxValue = 0, maxKey = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!answer.containsKey(arr[i])) {
				answer.put(arr[i], 1);
				if (maxKey == 0) {
					maxKey = arr[i];
					maxValue = 1;
				}
			} else {
				int currValue = answer.get(arr[i]);
				answer.put(arr[i], currValue + 1);
			}
		}
		
		//iterate
		Set<Integer> keys = answer.keySet();
		for (int key : keys) {
			if (answer.get(key) > maxValue) {
				maxKey = key;
				maxValue = answer.get(key);
			}
//			System.out.println(key + ": " + answer.get(key));
		}
		return maxKey;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int sze = s.nextInt();
		int[] arr = new int[sze];
		for(int index = 0;index<sze;index++){
			arr[index]=s.nextInt();
		}
		System.out.println(maxFrequencyNumber(arr));
		s.close();
	}

}
