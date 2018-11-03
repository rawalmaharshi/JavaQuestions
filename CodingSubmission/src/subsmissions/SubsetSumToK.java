package subsmissions;

import java.util.Scanner;

public class SubsetSumToK {
	
	private static int[][] subsetSumHelper (int [] input, int startIndex, int sum) {
		//base case
		if(startIndex >= input.length) {
			int [][] ans = null;
			if (sum == 0) {
				ans = new int[1][0];
			} else {
				ans = new int[0][0];
			}
			
			return ans;
		}
		
		int smallAns1[][] = subsetSumHelper(input, startIndex + 1, sum - input[startIndex]);
		int smallAns2[][] = subsetSumHelper(input, startIndex + 1, sum);
		
		int output[][] = new int[smallAns1.length + smallAns2.length][];
		
		int k = 0; 
		for (int i = 0; i < smallAns1.length; i++) {
			output[k] = new int[smallAns1[i].length + 1];
			output[k][0] = input[startIndex]; 
			for (int j = 0; j < smallAns1[i].length; j++) {
				output[k][j+1] = smallAns1[i][j];
			}
			k++;
		}
		
		for (int i = 0; i < smallAns2.length; i++) {
			output[k] = new int[smallAns2[i].length];
			
			for (int j = 0; j < smallAns2[i].length; j++) {
				output[k][j] = smallAns2[i][j];
			}
			k++;
		}
	return output;
	}
	
	public static int[][] subsetSum(int[] input, int sum) {
		return subsetSumHelper(input, 0, sum);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int input[] = new int[size];
		for (int i = 0; i < size; i++) {
			input[i] = s.nextInt();
		}
		int sum = s.nextInt();
		int output[][] = subsetSum(input, sum);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
		s.close();
	}
}
