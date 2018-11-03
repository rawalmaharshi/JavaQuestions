package subsmissions;

import java.util.Scanner;

public class PairSum {
	
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
	
	public static void pairSum(int[] arr, int num){
		//Sort the array first
		mergeSort(arr, 0, arr.length - 1);
		
		int i = 0, j = arr.length -1;
		while ( i < j) {
			if (arr[i] + arr[j] > num) {
				j--;
			} else if (arr[i] + arr[j] < num) {
				i++;
			} else {
				int i2 = i, countOfFirstPairElement = 1;
				int j2 = j, countOfSecondPairElement = 1;
				while (arr[i] == arr[i2 + 1] && i2 < (j2 - 1)) {
					i2++;
					countOfFirstPairElement++;
				}
				
				if ( i2 != (j2 -1)) {
					while (arr[j] == arr[j2 - 1] && j2 > i2) {
						j2--;
						countOfSecondPairElement++;
					}
				}
				
				int totalPairs = countOfFirstPairElement * countOfSecondPairElement;
				for ( int a = 0; a < totalPairs; a++)
					System.out.println(arr[i] + " " + arr[j]);
				
				//Moving forward
								
				if (i2 <= (j2 - 1)) {
					i = i2;
					j = j2;
					j--;
				}
				
				i++;
			}
		}
		
//		Ideal Code
//		int start = 0;
//		int end = arr.length - 1;
//		while ( start < end) {
//		    if (arr[start] + arr[end] == num) {
//		        if(arr[start] == arr[end]) {
//		            int count = end - start + 1;
//		            int n = count - 1;
//		            int totalCount = ((n) * (n + 1))/2;
//		            while(totalCount > 0) {
//		                System.out.println(arr[start] + " " + arr[end])
//		                totalCount--;
//		            }
//		            start = end;
//		        } else {
//		            int countStart = 0, countEnd = 0;
//		            int temp = arr[start], i = start;
//		            while (arr[i] == temp && i < end) {
//		                i++;
//		                countStart++;
//		            }
//		            temp = arr[end];
//		            int j = end;
//		            while (arr[j] == temp && j > start) {
//		                j--;
//		                countEnd++;
//		            }
//		            start = i;
//		            end = j;
//		            int totalTimes = countStart * countEnd;
//		            while(totalTimes > 0) {
//		                System.out.println(arr[start - 1] + " " + arr[end + 1]);
//		                totalTimes--;
//		            }
//		        }
//		    } else if (arr[start] + arr[end] < num)
//		        start++;
//		      else 
//		        end--;
//		}
		
	}
	
	//This is the code that I submitted, it has the complexity of O(n^2).
//	public static void pairSum(int[] arr, int num){
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = i + 1; j < arr.length; j++) {
//				if (arr[i] + arr[j] == num) {
//					if ( arr[i] < arr [j])
//						System.out.println(arr[i] + " " + arr[j]);
//					else
//						System.out.println(arr[j] + " " + arr[i]);
//				}
//			}
//		}
//	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		int num = s.nextInt();
		pairSum(arr, num);
		s.close();
	}

}
