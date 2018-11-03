package subsmissions;

import java.util.Scanner;

public class DuplicateInArray {
	
	public static int duplicate(int[] arr){  
		/* Your class should be named DuplicateInArray
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
		
		int sum = 0, N = arr.length;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		int sumOfNMinus2 = ((N - 2) * (N - 1)) / 2;
		int duplicate = sum - sumOfNMinus2;
		return duplicate;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		System.out.print(duplicate(arr));
		s.close();
	}

}
