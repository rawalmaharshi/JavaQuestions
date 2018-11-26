package dp;

import java.util.Scanner;

public class MinCostPath {
	
	public static int minCostPath(int[][] input, int sI, int eI) {
		//base case (2 cases)
		if (sI >= input.length || eI >= input[0].length) {
			return Integer.MAX_VALUE;
		}
		
		if (sI == (input.length - 1) && eI == (input[0].length - 1)) { //can use any index {2-d array has same no. of rows throughout}
			return input[sI][eI];
		}
		
		int answer = input[sI][eI];
		int option1 = minCostPath(input, sI, eI + 1);
		int option2 = minCostPath(input, sI + 1, eI + 1);
		int option3 = minCostPath(input, sI + 1, eI);
		
		answer += Math.min(option1, Math.min(option2, option3));
		return answer;
	}	
	
	public static int minCostPath(int input[][]) {
		return minCostPath(input, 0, 0);
	}
	
	public static int minCostPathM(int input[][]) {
		int storage[][] = new int[input.length][input[0].length]; //Array to store min path from resp. indices
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				storage[i][j] = -1;
			}
		}
		return minCostPathM(input, 0, 0, storage);
	}
	
	private static int minCostPathM(int input[][], int i, int j, int storage[][]) {
		//base case(s)
		if (i >= input.length || j >= input[0].length) {
			return Integer.MAX_VALUE;
		}
		
		if (i == (input.length - 1) && j == (input[0].length - 1)) { 
			storage[i][j] = input[i][j];
			return storage[i][j];
		}
		
		if (storage[i][j] != -1) {
			return storage[i][j];
		}
		
		int option1 = minCostPathM(input, i, j + 1, storage);
		int option2 = minCostPathM(input, i + 1, j + 1, storage);
		int option3 = minCostPathM(input, i + 1, j, storage);
		
		storage[i][j] = input[i][j] + Math.min(option1, Math.min(option2, option3));
		return storage[i][j];
	}
	
	public static int minCostPathDP(int input[][]) {
		int m = input.length;
		int n = input[0].length;
		int storage[][] = new int[m][n]; //Array to store min path from resp. indices
		
		storage[m - 1][n - 1] = input[m - 1][n - 1]; //Min cost to reach the last cell from last cell is value of that cell
		
		//Last Row
		for (int j = n - 2; j >= 0; j--) {
			storage[m - 1][j] = input[m - 1][j] + storage[m - 1][j + 1];
		}
		
		//Last Column
		for (int i = m - 2; i >= 0; i--) {
			storage[i][n - 1] = input[i][n - 1] + storage[i + 1][n - 1];
		}
		
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				storage[i][j] = input[i][j] + Math.min(storage[i][j+1], Math.min(storage[i+1][j+1], storage[i+1][j]));
			}
		}
		
		return storage[0][0];
	}
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int m = s.nextInt();
		int n = s.nextInt();
		int input[][] = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				input[i][j] = s.nextInt();
			}
		}
		System.out.println(minCostPathDP(input));
		System.out.println(minCostPathM(input));
		System.out.println(minCostPath(input));
	}
}
