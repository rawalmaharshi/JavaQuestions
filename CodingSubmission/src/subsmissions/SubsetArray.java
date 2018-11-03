package subsmissions;

import java.util.Scanner;

public class SubsetArray {
	
	private static int[][] subsets (int input [], int ansArrayIndex) {
		
		if (input.length == 0) {
			int [][] ans = {{}};
			return ans;
		}
		
		int [] smallInput = new int[input.length - 1];
		for (int i = 0; i < smallInput.length; i++)
			smallInput[i] = input[i + 1];
		
		int [][] smallAns = subsets (smallInput, ansArrayIndex);
		int [][] ans = new int[2 * smallAns.length][];
		
		for (int a = 0 ; a < smallAns.length; a++) {
			ans[ansArrayIndex] = new int [smallAns[a].length];
			for(int j = 0; j < smallAns[a].length; j++) {
				ans[ansArrayIndex][j] = smallAns[a][j];
			}
			ansArrayIndex++;
		}

		for (int a = 0 ; a < smallAns.length; a++) {
			ans[ansArrayIndex] = new int [smallAns[a].length + 1];
			ans[ansArrayIndex][0] = input[0];
			for(int j = 0; j < smallAns[a].length; j++) {
				ans[ansArrayIndex][j + 1] = smallAns[a][j];
			}
			ansArrayIndex++;
		}
		
		return ans;
	}
	
	public static int[][] subsets(int input[]) {
		// Write your code here
		return subsets(input, 0);
	}

	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		s.close();
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int output[][] = subsets(input);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}
}

//public static int[][] subsetsHelper(int[] input, int startIndex){
//
//	if(startIndex == input.length){ 
//		int[][] output = new int[1][0]; 
//		return output; 
//	}
//
//	int[][] smallerOutput = subsetsHelper(input, startIndex + 1); 
//	int[][] output = new int[2*smallerOutput.length][];
//
//	int k = 0; 
//	for(int i = 0; i < smallerOutput.length; i++){ 
//		output[k] = new int[smallerOutput[i].length]; 
//		for(int j = 0; j<smallerOutput[i].length; j++){ 
//			output[k][j] = smallerOutput[i][j]; 
//		} 
//		k++; 
//	} 
//
//	for(int i = 0; i < smallerOutput.length; i++){ 
//		output[k] = new int[smallerOutput[i].length+1]; 
//		output[k][0] = input[startIndex]; 
//
//		for(int j = 1; j <= smallerOutput[i].length; j++){ 
//			output[k][j] = smallerOutput[i][j-1]; 
//		} 
//	k++; 
//	} 
//
//return output; 
//} 
//
//
//public static int[][] subsets(int input[]) { 
//	return subsetsHelper(input, 0); 
//}


