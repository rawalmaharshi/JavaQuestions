import java.util.Scanner;

public class LastIndex {
	
	private static int lastIndex (int input[], int x, int startIndex, int lastIndexOfElement) {
		
		if (input[startIndex] == x) {
			lastIndexOfElement = startIndex;
		}
		
		if (startIndex == input.length - 1) { //Reached the end of array
			return lastIndexOfElement;
		}
		
		lastIndexOfElement = lastIndex(input, x, startIndex + 1, lastIndexOfElement);
		return lastIndexOfElement;
	}

	public static int lastIndex (int input[], int x) {
		return lastIndex(input, x, 0, -1);
	}
	
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int arraySize = s.nextInt();
		int[] input = new int[arraySize];
		
		for (int i = 0; i < arraySize; i++) {
			input[i] = s.nextInt();
		}
		int x = s.nextInt();
		System.out.println(lastIndex(input, x));
		
		s.close();
	}
}
