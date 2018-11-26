package maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class LongestConsecutiveSequence {
	
	public static ArrayList<Integer> longestSubsequence(int[] arr){
		ArrayList<Integer> answer = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int elem : arr) {
			map.put(elem, true);
		}
		int maxLength = 0, currLength = 0;
		
		Set<Integer> keys = map.keySet();
		
		for (int key : keys) {
			if (map.get(key)) {
				if (map.containsKey(key + 1) || map.containsKey(key - 1) || currLength == 0) {
					currLength++;
					temp.add(key);
					map.put(key, false);
				}
				
				if (map.containsKey(key + 1) && map.get(key + 1) == true) {
					continue;
				} else if (map.containsKey(key - 1) && map.get(key - 1) == true) {
					temp.add(key - 1);
					currLength++;
					map.put((key - 1), false);
					continue;
				} else {
					if (currLength > maxLength) {
						answer.clear();
						for(int a : temp) {
							answer.add(a);
						}
						maxLength = currLength;
					}
					currLength = 0;
					temp.clear();
				}
			}
		}
		
		if (answer.size() == 1 && arr.length > 1) {
			answer.clear();
			answer.add(arr[0]);
		}
		return answer;
	}
	
	public static ArrayList<Integer> solution2(int[] arr) {
		int firstElement = arr[0];
		Arrays.sort(arr);
		ArrayList<Integer> answer = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		
		int currLength = 0, maxLength = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			temp.add(arr[i]);
			currLength++;
			if(arr[i+1] == arr[i] + 1) {
				continue;
			} else {
				if (currLength > maxLength) {
					answer.clear();
					for(int a : temp) {
						answer.add(a);
					}
					maxLength = currLength;
				}
				currLength = 0;
				temp.clear();
			}
		}
		
		if (answer.size() == 1 && arr.length > 1) {
			answer.clear();
			answer.add(firstElement);
		}
		return answer;
	}
	
	public static ArrayList<Integer> finalSolution (int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int elem : arr) {
			map.put(elem, true);
		}
		int maxLength = 0, currLength = 0;
		
		Set<Integer> keys = map.keySet();
		for (int key : keys) {
			int tempKey = key;
			System.out.println(tempKey);
			temp.add(key);
			currLength++;
//			while (map.containsKey(key + 1)) {
//				currLength++;
//				temp.add(key + 1);
//			}

			if (currLength > maxLength) {
				answer.clear();
				for(int a : temp) {
					answer.add(a);
				}
				maxLength = currLength;
			}
			currLength = 0;
			temp.clear();
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
//		ArrayList<Integer> ans = longestSubsequence(arr);
		ArrayList<Integer> ans = finalSolution(arr);
		for(int i : ans) {
			System.out.println(i);
		}
		s.close();
	}
}
