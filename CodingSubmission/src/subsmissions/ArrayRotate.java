package subsmissions;

import java.util.Scanner;

public class ArrayRotate {
	
	public static void rotate(int[] arr, int d) {
		
		if ( d > arr.length) {
			d = d - arr.length;
		}
		
		int[] smallArray = new int [d];
		for (int i = 0; i < smallArray.length; i++) 
			smallArray[i] = arr[i];
		
		int i = 0;
		for ( ; i < arr.length - d ;i++) 
			arr[i] = arr[i + d];
		
		for (int j = 0; i < arr.length ; i++, j++) 
			arr[i] = smallArray[j];

	}
	
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		int index = s.nextInt();
		rotate(arr, index);
		print(arr);
		
		s.close();
	}

}
