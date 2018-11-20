package maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class PrintIntersection {
	
	public static void intersection(int[] arr1, int[] arr2){
		HashMap<Integer, Integer> array1 = new HashMap<>();
		HashMap<Integer, Integer> array2 = new HashMap<>();
		for (int element : arr1) {
			if (!array1.containsKey(element)) {
				array1.put(element, 1);
			} else {
				int value = array1.get(element);
				array1.put(element, value + 1);
			}
		}
		
		for (int element : arr2) {
			if (!array2.containsKey(element)) {
				array2.put(element, 1);
			} else {
				int value = array2.get(element);
				array2.put(element, value + 1);
			}
		}
		
		//iterate
		Set<Integer> keys = array1.keySet();
		for (Integer key : keys) {
			if (array2.containsKey(key)) {
				int valueOfKeyInArray1 = array1.get(key);
				int valueOfKeyInArray2 = array2.get(key);
				while (valueOfKeyInArray1 > 0 && valueOfKeyInArray2 > 0) {
					System.out.println(key);
					valueOfKeyInArray1--;
					valueOfKeyInArray2--;
				}
			}
//			System.out.println(key + ": " + array1.get(key));
		}

	}
	
	static Scanner s = new Scanner(System.in);
	public static int[] takeInput() {
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}

	public static void print(ArrayList<Integer> list) {
		for (int i : list) {
			System.out.print(i+" ");
		}
	}
	
	public static void main(String[] args) {
		int[] arr1 = takeInput();
		int[] arr2 = takeInput();
		intersection(arr1, arr2);
	}
}
