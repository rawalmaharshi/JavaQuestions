package maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SubsetZeroSum {
	
	public static int lengthOfLongestSubsetWithZeroSum(ArrayList<Integer> arr) {
		HashMap<Integer, Integer> map = new HashMap<>();    //first is value, second is index
		int maxLength = 0, sum = 0;
		
		for (int i = 0; i < arr.size(); i++) {
			sum += arr.get(i);
			
			if (arr.get(i) == 0 && maxLength == 0) {
				maxLength = 1;
			}
			
			if (sum == 0) {
				maxLength = i + 1;
			}
			
			Integer pI = map.get(sum);
			
			if (pI != null) {
				maxLength = Math.max(maxLength, i - pI);
			} else {
				map.put(sum, i);
			}
		}

		return maxLength;
   	}
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();

		int size = scan.nextInt();
		for(int i = 0; i < size; i++)
			arr.add(scan.nextInt());

		System.out.println(lengthOfLongestSubsetWithZeroSum(arr));
		scan.close();
	}
}
