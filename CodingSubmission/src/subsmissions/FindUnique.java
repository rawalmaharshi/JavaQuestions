package subsmissions;

import java.util.Scanner;

public class FindUnique {

	public static int findUnique(int[] arr){
		
		int element = 0;
		for (int i = 0; i < arr.length; i++) {
			element = element ^ arr[i];
		}

		return element;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}

		System.out.print(findUnique(arr));
		s.close();
	}

}
