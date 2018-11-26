package dp;

import java.util.Scanner;

public class Knapsack01 {
	
	public static int knapsack(int[] weight,int value[],int maxWeight, int n){
		return knapsack(weight, value, maxWeight, n, 0, 0);
	}
	
	private static int knapsack(int[] weight, int[] value, int maxWeight, int n, int currIndex, int currValue) {
		//base case
		if (currIndex >= n || maxWeight == 0) {
			return currValue;
		} 
		
		if (weight[currIndex] > maxWeight) {
			return knapsack(weight, value, maxWeight, n, currIndex + 1, currValue);
		} else {
			//include the current value 
			int option1 = knapsack(weight, value, maxWeight - weight[currIndex], n, currIndex + 1, currValue + value[currIndex]);
			//exclude
			int option2 = knapsack(weight, value, maxWeight, n, currIndex + 1, currValue);
			return Math.max(option1, option2);
		}
	}
	
	public static int knapsackM (int[] weight, int value[], int maxWeight, int n) {
		int [] storage = new int [n + 1];
		return 1;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int weight[] = new int[n];
		for(int i = 0 ; i < n; i++){
			weight[i] = s.nextInt();
		}
		int value[] = new int[n];
		for(int i = 0 ; i < n; i++){
			value[i] = s.nextInt();
		}
		int maxWeight = s.nextInt();
		System.out.println(knapsack(weight, value, maxWeight, n));		
		s.close();
	}

}
