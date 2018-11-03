package subsmissions;

import java.util.Scanner;

public class Intersection {
	
	public static void mergeSort (int[] input, int sI, int eI) {
		
		if (sI >= eI) {
			return;	
		}
		
		int mid = (sI + eI) / 2;
		
		mergeSort(input, sI, mid);
		mergeSort(input, mid + 1, eI);
		merge(input, sI, eI);
	}
	
	private static void merge (int [] input, int sI, int eI) {
		int mergedArray[] = new int[eI - sI + 1];
		int mI = (sI + eI) / 2;
		int i = sI, j = mI + 1, k = 0;
				
		while (i <= mI && j <= eI) {
			if (input [i] < input [j]) {
				mergedArray[k] = input[i];
				i++;
				k++;
			} else {
				mergedArray[k] = input[j];
				j++;
				k++;
			}
		}
		
		while (i <= mI) {
			mergedArray[k] = input[i];
			i++;
			k++;
		}
		
		while (j <= eI) {
			mergedArray[k] = input[j];
			j++;
			k++;
		}
		
		for (int a = 0; a < mergedArray.length; a++) {
			input[sI + a] = mergedArray[a];
		}
	}
	
	
	public static void intersection(int[] arr1, int[] arr2){
			
		mergeSort(arr1, 0, arr1.length - 1);
		mergeSort(arr2, 0, arr2.length - 1);
		
		int i = 0, j = 0;
		while ( i < arr1.length && j < arr2.length) {
			if ( arr1[i] < arr2[j] && j < arr2.length) {
				i++;
			}
			else if ( arr2[j] < arr1[i] && j < arr2.length) {
				j++;
			}
			else {
				System.out.println(arr1[i]);
				i++;
				j++;
			}
		}
		
	}
	
	static Scanner s = new Scanner(System.in);
	public static int[] takeInput() {
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr1 = takeInput();
		int[] arr2 = takeInput();
		intersection(arr1, arr2);
	}

}
