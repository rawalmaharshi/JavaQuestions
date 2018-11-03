package subsmissions;

import java.util.Scanner;

public class QuickSort {
	
	static int partition (int [] input, int startIndex, int endIndex) {
		
		int pivot = input[startIndex];
		
		int count = 0;
		for (int i = startIndex + 1; i <= endIndex; i++) {
			if (input[i] < pivot) {
				count++;
			}
		}
		
		int pivotPos = startIndex + count;
		
		//Swap the element at pivotPos with present position of pivot
		int temp = input[startIndex];
		input[startIndex] = input[pivotPos];
		input[pivotPos] = temp;
		
		int i = startIndex, j = endIndex;
		while (i < pivotPos && j > pivotPos) {
			if (input[i] < pivot) {
				i++;
			} else if (input[j] >= pivot) {
				j--;				
			} else {
				// Swap elements at position i and j
				input[i] = input[i] + input[j];
				input[j] = input[i] - input[j];
				input[i] = input[i] - input[j];
				i++;
				j--;
			} 
		}

		return pivotPos;
	}
	
	private static void quickSort (int [] input, int startIndex, int endIndex) {
		//Base Case
		if (startIndex >= endIndex) {
			return ;
		}
		
		int pivotPos = partition(input, startIndex, endIndex);
		quickSort(input, startIndex, pivotPos - 1);
		quickSort(input, pivotPos + 1, endIndex);
	}
	
	public static void quickSort(int[] input) {
		quickSort(input, 0, input.length - 1);
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++){
			input[i] = s.nextInt();
		}
		QuickSort.quickSort(input);
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		s.close();
	}

}
