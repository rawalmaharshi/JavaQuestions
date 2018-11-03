
public class MergeSort {
	
	public static void mergeSort (int[] input, int sI, int eI) {
		
		if (sI >= eI) {
			return;	
		}
		
		int mid = (sI + eI) / 2;
		
		mergeSort(input, sI, mid);
		mergeSort(input, mid + 1, eI);
		merge(input, sI, eI);
	}
	
	private static void merge (int [] input, int sI, int eI) {
		int mergedArray[] = new int[eI - sI + 1];
		int mI = (sI + eI) / 2;
		int i = sI, j = mI + 1, k = 0;
				
		while (i <= mI && j <= eI) {
			if (input [i] < input [j]) {
				mergedArray[k] = input[i];
				i++;
				k++;
			} else {
				mergedArray[k] = input[j];
				j++;
				k++;
			}
		}
		
		while (i <= mI) {
			mergedArray[k] = input[i];
			i++;
			k++;
		}
		
		while (j <= eI) {
			mergedArray[k] = input[j];
			j++;
			k++;
		}
		
		for (int a = 0; a < mergedArray.length; a++) {
			input[sI + a] = mergedArray[a];
		}
	}

	public static void main(String[] args) {
		int[] input = {6, 2, 20, 8, 15, 4, 3};
		mergeSort(input, 0, input.length - 1);
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}

}
