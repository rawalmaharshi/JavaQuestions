public class SelectionSort {

	public static void selectionSort (int [] input) {
		for(int beginIndex = 0; beginIndex < input.length; beginIndex++) {
			int min = input[beginIndex];
			int minPos = beginIndex;
			
			for (int i = beginIndex; i < input.length; i++) {
				if (input[i] < min) {
					min = input[i];
					minPos = i;
				}
			}
			
			int temp = input[minPos];
			input[minPos] = input[beginIndex];
			input[beginIndex] = temp;
		}
	}
	
	public static void main (String[] args) {
		for (int n = 10; n <=10000000; n = n* 10) {
			int[] input = new int[n];
			for (int i = 0; i < input.length; i++) {
				input[i] = input.length - i;
			}
			
			long startTime = System.currentTimeMillis();
			selectionSort(input);
			long endTime = System.currentTimeMillis();
			System.out.println("Time by selection sort for " + n + " is " + (endTime - startTime));
		}
	}
}
