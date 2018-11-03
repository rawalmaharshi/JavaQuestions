package subsmissions;

import java.util.Scanner;

public class BinarySearch {
	
	private static int binarySearch (int input[], int element, int startIndex, int endIndex) {
		
		if (startIndex == endIndex && input[startIndex] == element) {
			return startIndex;
		}
		
		else if (startIndex == endIndex && input[startIndex] != element) {
			return -1;
		} 
		
		int midIndex = (startIndex + endIndex)/2;
		int midTerm = input[midIndex];
		if (element == midTerm) {
			return midIndex;
		} else if (element < midTerm ) {
			endIndex = midIndex - 1;
		} else {
			startIndex = midIndex + 1;
		}
		
		return binarySearch(input, element, startIndex, endIndex);
	}
	
	public static int binarySearch(int input[], int element) {
		// Write your code here
		return binarySearch(input, element, 0, input.length - 1);
	}
	
	public static void main (String[] args) {

		Scanner s = new Scanner(System.in);
		int arraySize = s.nextInt();
		int[] input = new int[arraySize];
		
		for (int i = 0; i < arraySize; i++) {
			input[i] = s.nextInt();
		}
		
		int x = s.nextInt();
		System.out.println(binarySearch(input, x));
		
		s.close();
	}
	
}