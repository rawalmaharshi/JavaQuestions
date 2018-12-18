package dp;

import java.util.Scanner;

public class MaxSquareMatrixWithZero {

	public static int findMaxSquareWithAllZeros(int[][] input) {
		int [][] storage = new int [input.length][input[0].length];
		int Max = 0;
		
		//Fill the 1st column
		for (int i  =  0; i < input.length; i++) {
			if (input[i][0] == 0) {
				Max = 1;
				storage[i][0] = 1;
			} else {
				storage[i][0] = 0;
			}
		}
		
		//Fill the 1st row
		for (int j = 0; j < input[0].length; j++) {
			if (input[0][j] == 0) {
				Max = 1;
				storage[0][j] = 1;
			} else {
				storage[0][j] = 0;
			}
		}
		
		
		for (int i = 1; i < input.length; i++) {
			for (int j = 1; j < input[0].length; j++) {
				if (input[i][j] == 1) {
					storage[i][j] = 0;
				} else {
					storage[i][j] = Math.min(storage[i-1][j-1], Math.min(storage[i-1][j], storage[i][j-1])) + 1;
					if (storage[i][j] > Max) {
						Max = storage[i][j];
					}
				}
			}
		}
		
		return Max;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int arr[][] = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				arr[i][j] = s.nextInt();
		System.out.println(findMaxSquareWithAllZeros(arr));
		s.close();
	}
}
