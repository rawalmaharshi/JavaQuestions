package maps;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class MaxFrequencyNumber {
	
	public static int maxFrequencyNumber(int[] arr){
		HashMap<Integer, Integer> answer = new HashMap<>();
		int maxValue = 1, maxKey = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!answer.containsKey(arr[i])) {
				answer.put(arr[i], 1);
			} else {
				int currValue = answer.get(arr[i]);
				answer.put(arr[i], ++currValue);
				
				
			}
			int currValue = answer.get(arr[i]);
			if (currValue > maxValue) {
				maxValue = currValue;
				maxKey = arr[i];
			}
		}
		
		Set<Integer> keys = answer.keySet();
		for (Integer i : keys) {
			System.out.println(i + ": " + answer.get(i));
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
