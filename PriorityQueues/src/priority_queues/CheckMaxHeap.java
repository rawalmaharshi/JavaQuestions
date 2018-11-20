package priority_queues;

import java.util.Scanner;

public class CheckMaxHeap {
	
	public static boolean checkMaxHeap(int arr[]) {

		int parentIndex = 0;
		int leftChildIndex = 2 * parentIndex + 1;
		int rightChildIndex = 2 * parentIndex + 2;
		
		while (parentIndex < arr.length) {
			if (leftChildIndex < arr.length && arr[parentIndex] < arr[leftChildIndex]) {
				return false;
			}
			
			else if (rightChildIndex < arr.length  && arr[parentIndex] < arr[rightChildIndex]) {
				return false;
			} else {
				parentIndex++;
				leftChildIndex = 2 * parentIndex + 1;
				rightChildIndex = 2 * parentIndex + 2;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = s.nextInt();
		}
		
		System.out.println(checkMaxHeap(arr));
		s.close();
	}

}
