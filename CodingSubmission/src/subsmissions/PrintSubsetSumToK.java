package subsmissions;

import java.util.Scanner;

public class PrintSubsetSumToK {
	
	private static void printSubsetsSumTok (int input[], int startIndex, int sum, int output[]) {
		//base case
		if(startIndex >= input.length) {
			if (sum == 0) {
				for (int i = 0; i < output.length; i++) {
					System.out.print(output[i] + " ");
				}
				System.out.println();
				return;
			}
			else {
				return;
			}
		}
		
		int [] newOp = new int[output.length + 1];
		int i = 0;
		for( ; i < output.length; i++) 
			newOp[i] = output[i];
		newOp[i] = input[startIndex];
		
		printSubsetsSumTok(input, startIndex + 1, sum - input[startIndex], newOp);
		printSubsetsSumTok(input, startIndex + 1, sum, output);
	}
	
	public static void printSubsetsSumTok(int input[], int k) {
		// Write your code here
		int output[] = new int[0];
		printSubsetsSumTok(input, 0, k, output);
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
		int[] input = takeInput();
		int k = s.nextInt();
		printSubsetsSumTok(input, k);
	}

}
