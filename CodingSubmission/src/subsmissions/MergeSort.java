package subsmissions;

import java.util.Scanner;

public class MergeSort {
	
	private static void merge(int[] input, int startIndex, int midIndex, int endIndex) {
		System.out.println("SI: " + startIndex);System.out.println("MI: " + midIndex);System.out.println("EI: " + endIndex);
		int arrLSize = midIndex - startIndex + 1;
		int arrRSize = endIndex - midIndex;
		
		int[] arrLeft = new int [arrLSize];
		int[] arrRight = new int [arrRSize];
				
		//Initialize Left and Right Arrays
		for (int i = 0; i < arrLSize; i++) {
			arrLeft[i] = input[startIndex + i];	
		}
		
		for(int j = 0; j < arrRSize; j++) {
			arrRight[j] = input[midIndex + 1 + j];
		}
		
		int i = 0, j = 0, k = startIndex;
		while (i < arrLSize && j < arrRSize) {
			if (arrLeft[i] <= arrRight[j]) {
				input[k] = arrLeft[i];
				i++;
			} else {
				input[k] = arrRight[j];
				j++;
			}
			k++;
		}
		
		
		while (i < arrLSize) 
	        { 
	            input[k] = arrLeft[i]; 
	            i++; 
	            k++; 
	        } 
	  
        while (j < arrRSize) 
        { 
            input[k] = arrRight[j]; 
            j++; 
            k++; 
        } 
		
	}
	
	private static void mergeSort (int[] input, int startIndex, int endIndex) {
		
		if(startIndex < endIndex) {
			int midIndex = (startIndex + endIndex) / 2;
			
			mergeSort(input, startIndex, midIndex);
			mergeSort(input, midIndex + 1, endIndex);
			merge (input, startIndex, midIndex, endIndex);
		}
	}

	public static void mergeSort(int[] input){
		// Write your code here
		mergeSort(input, 0, input.length - 1);
	}
	
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		s.close();
		return arr;
	}
	
	public static void printArray(int input[]) {
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		mergeSort(input);
		printArray(input);
	}

}
