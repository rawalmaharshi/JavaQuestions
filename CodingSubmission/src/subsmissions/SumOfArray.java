package subsmissions;

import java.util.Scanner;

public class SumOfArray {

	public static int sum(int input[]) {
		
		//Base case
		if (input.length == 1) {
			return input[0]; //Returns the first element
		}
		
		//Make a new array of size n -1 
		int smallInput[] = new int[input.length - 1];
		
		//Copies the elements of input to smallInput
		for (int i = 1; i < input.length; i++)
			smallInput[i - 1] = input [i];
		
		//Add the first element to the return result of the subsequent sum call
		int sum = input[0] + sum(smallInput);
		return sum ;
	}
	
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int arraySize = s.nextInt();
		int[] input = new int[arraySize];
		
		for (int i = 0; i < arraySize; i++) {
			input[i] = s.nextInt();
		}
		
		System.out.println("The sum of array elements is: " + sum(input));
		
		s.close();
	}

}
