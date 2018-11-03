package subsmissions;

import java.util.Scanner;

public class SubsetPrint {
	
	private static void printSubsets (int input[], int startIndex, int output[], int opIndex) {
		
		//base case
		if (startIndex >= input.length) {
			for (int i = 0 ; i < output.length; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println("");
			return;
		}
		
		printSubsets(input, startIndex + 1, output, opIndex);
		
		int newOutput[] = new int[output.length + 1];

		newOutput[opIndex] = input[startIndex];
		opIndex++;
		for (int i = 0; i < output.length; i++) 
			newOutput[i] = output[i];
		printSubsets(input, startIndex + 1, newOutput, opIndex);
	
	}
	
	public static void printSubsets(int input[]) {
		// Write your code here
		int[] output = new int[0];
		printSubsets(input,0, output, 0);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		printSubsets(arr);
		s.close();
	}

}
