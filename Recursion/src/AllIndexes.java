import java.util.Scanner;

public class AllIndexes {

	private static int[] allIndexes(int input[], int x, int startIndex, int indexArray [], int indexArrayIndex) {
		
		if (x == input[startIndex]) {
			//Add to indexArray
			indexArray[indexArrayIndex] = startIndex;
		} else {
			indexArray[indexArrayIndex] = -1;
		}
		indexArrayIndex ++;
		
		if (startIndex == input.length - 1) {
			return indexArray;
		}
		
		allIndexes(input, x, startIndex +1, indexArray, indexArrayIndex);
		return indexArray;
	}
	
	public static int[] allIndexes(int input[], int x) {
		int [] indexArray = new int[input.length];  //Make an array equivalent to size of input
//		int indexArrayIndex = 0;
		indexArray = allIndexes(input, x, 0, indexArray, 0);
		
		int count = 0;
		for(int i = 0; i < indexArray.length; i++) {
			if(indexArray[i] == -1) {
				count++;
			}
		}
		
		int returnArrayIndex = 0;
		int [] returnArray = new int[indexArray.length - count];
		for(int i = 0; i < indexArray.length; i++) {
			if (indexArray [i] != -1) {
				returnArray[returnArrayIndex] = indexArray[i];
				returnArrayIndex++;
			}
		}
		return returnArray;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int arraySize = s.nextInt();
		int[] input = new int[arraySize];
		
		for (int i = 0; i < arraySize; i++) {
			input[i] = s.nextInt();
		}
		int x = s.nextInt();
		int [] returnArray = allIndexes(input, x);
		for(int i = 0; i < returnArray.length; i++) {
			if(returnArray[i] != -1)
				System.out.print(returnArray[i] + " ");
		}
		
		s.close();
	}
}