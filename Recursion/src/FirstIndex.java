import java.util.Scanner;

public class FirstIndex {
	
	private static int firstIndex (int input[], int x, int startIndex) {
		
		if (input[startIndex] == x) {
			return startIndex;
		}
		
		if (startIndex == input.length - 1) {
			return -1; //element not found
		}
		
		int indexNum = firstIndex(input, x, startIndex + 1);
		return indexNum;
	}

	public static int firstIndex (int input[], int x) {
		return firstIndex(input, x, 0);
	}
	
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int arraySize = s.nextInt();
		int[] input = new int[arraySize];
		
		for (int i = 0; i < arraySize; i++) {
			input[i] = s.nextInt();
		}
		int x = s.nextInt();
		System.out.println(firstIndex(input, x));
		
		s.close();
	}
}
