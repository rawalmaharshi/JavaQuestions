package maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;

public class LongestConsecutiveSequence {
	
	public static ArrayList<Integer> longestSubsequence(int[] arr){
		Arrays.sort(arr);
		ArrayList<Integer> answer = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int elem : arr) {
			map.put(elem, true);
		}
		int maxLength = 0, currLength = 0;
		
		Set<Integer> keys = map.keySet();
//		for (int key : keys) {
//			System.out.println(key + ": " + map.get(key));
//		}
		
		for (Integer key : keys) {
			if (map.containsKey(key + 1)) {
				temp.add(key);
				currLength++;
				if (currLength > maxLength) {
					maxLength = currLength;
				}
				continue;
			} else {
				if (temp.size() > answer.size()) {
					answer.clear();
					answer = temp;
					temp.clear();
				}
			}
		}
			
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int sze=s.nextInt();
		int[] arr = new int[sze];
		for(int index = 0;index<sze;index++){
			arr[index]=s.nextInt();
		}
		ArrayList<Integer> ans = longestSubsequence(arr);
		for(int i : ans) {
			System.out.println(i);
		}
		s.close();
	}
}
