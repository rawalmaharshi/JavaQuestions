package bst;

import java.util.ArrayList;
import java.util.Scanner;

public class PairSum {
	
	private static void mergeSort (int[] input, int sI, int eI) {
		
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

	
	private static ArrayList<Integer> arrayBuilder (BinaryTreeNode<Integer> root, int sum, ArrayList<Integer> temp) {
		if (root == null) {
			return null;
		}
		
		temp.add(root.data);
		arrayBuilder(root.left, sum, temp);
		arrayBuilder(root.right, sum, temp);
		
		return temp;
	}
	
	public static void nodesSumToS(BinaryTreeNode<Integer> root, int sum) {
		ArrayList<Integer> temp = new ArrayList<>();
		temp = arrayBuilder(root, sum, temp);
		int[] tempArray = new int[temp.size()];
		for (int i = 0; i < temp.size(); i++) {
			tempArray[i] = temp.get(i);
		}
		mergeSort(tempArray, 0, tempArray.length - 1);
		
		for (int i = 0, j = tempArray.length - 1; i < j; ) {
			if (tempArray[i] + tempArray[j] > sum) {
				j--;
			} else if (tempArray[i] + tempArray[j] < sum) {
				i++;
			} else {
				System.out.println(tempArray[i] + " " + tempArray[j]);
				i++;
				j--;
			}	
		}
	}
	
	static Scanner s = new Scanner(System.in);
 	static int sum ;
	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); // we can skip writing again inside <> after java version 1.7
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = s.nextInt();
			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = s.nextInt();
			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		sum = s.nextInt();
		return root;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		nodesSumToS(root, sum);
	}
}
