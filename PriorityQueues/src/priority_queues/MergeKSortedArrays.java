package priority_queues;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKSortedArrays {
	
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < input.size(); i++) {
			ArrayList<Integer> current = input.get(i);
			for (int j = 0; j < current.size(); j++) {
				pq.add(current.get(j));
			}
		}
		ArrayList<Integer> answer = new ArrayList<>();
		while (!pq.isEmpty()) {
			answer.add(pq.remove());
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		while(k > 0) {
			int n = s.nextInt();
			ArrayList<Integer> current = new ArrayList<Integer>();
			for(int i = 0; i < n; i++) {
				current.add(s.nextInt());
			}
			input.add(current);
			k--;
		}
		ArrayList<Integer> output = mergeKSortedArrays(input);
		for(int i : output) {
			System.out.print(i + " ");
		}
		s.close();
	}
}
