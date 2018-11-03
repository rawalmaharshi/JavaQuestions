package subsmissions;

import java.util.Scanner;

public class TripletSum {
	
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
	
	public static void FindTriplet(int[] arr, int x){
		
		//Sort the array first
		quickSort(arr, 0, arr.length - 1);
		
		for(int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if (arr[i] + arr[j] + arr[k] == x) {
						System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
					}
				}
			}
		}
		
		//Ideal Solution
//		for ( int i = 0; i < input.length; i++) {
//		    int st = i + 1;
//		    int end = input.length - 1;
//		    int val = x-input[i];
//
//		    while(st<end) {
//		        if(input[st] + input[end] > val)
//		            end--;
//		        else if (input[st] + input[end] < val) 
//		            st++;
//		        else {
//		            int count1 = 0, count2 = 0;
//		            for (int ptr=st; ptr <= end; ptr++) {
//		                if(input[ptr] == input[st])
//		                    count1++;
//		                else   
//		                    break;
//		            }
//		            for (int ptr = end; ptr>=st; ptr--) {
//		                if (input[ptr] == input[end])
//		                    count2++;
//		                else
//		                    break;
//		            }
//		            int combinations = count1 * count2;
//		            if(input[st] == input[end])
//		                combinations = ((end - st + 1) * (end -st)) / 2;
//		            for(int k = 0; k < combinations; k++) {
//		                System.out.println(input[i] + " " + input[st] + " " + input[end]);
//		            }
//		            st = st + count1;
//		            end = end - count2;
//		        }
//		    }
//		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		int num = s.nextInt();
		FindTriplet(arr, num);
		s.close();

	}

}
