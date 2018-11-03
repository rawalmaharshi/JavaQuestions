import java.util.Scanner;

public class CheckNumber {

	public static boolean checkNumber(int input[], int x) {
		if(x == input[0])
			return true;
		
		if(input.length > 1) {
			int [] smallInput = new int[input.length - 1];
			for (int i = 1; i < input.length; i ++) {
				smallInput[i - 1] = input[i];
			}
			
			boolean isNumberPresent = checkNumber(smallInput, x);
//			if(!isNumberPresent) {
//				return false;
//			} else {
//				return true;
//			}
			return isNumberPresent;
		}
		
		return false;		
		
	}
	
	private static boolean checkNumberBetter (int [] input, int x, int startIndex) {
		
		//element found
		if(input[startIndex] == x) {
			return true;
		}
		
		//base case
		if (startIndex == input.length - 1) {
			return false;
		}
		
		
		boolean isNumberPresent = checkNumberBetter (input, x, startIndex + 1);
		return isNumberPresent;
	}
	
	public static boolean checkNumberBetter(int [] input, int x) {
		return checkNumberBetter(input, x, 0);
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int arraySize = s.nextInt();
		int[] input = new int[arraySize];
		
		for (int i = 0; i < arraySize; i++) {
			input[i] = s.nextInt();
		}
		int x = s.nextInt();
		System.out.println(checkNumberBetter(input, x));
		
		s.close();
	}
}
