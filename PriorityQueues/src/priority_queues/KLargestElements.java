package priority_queues;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElements {

	public static ArrayList<Integer> kLargest(int input[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		ArrayList<Integer> answer = new ArrayList<>();
		
		int i = 0;
		for ( ; i < k; i++) {
			pq.add(input[i]);
		}
		
		for ( ; i < input.length; i++) {
			int min = pq.element();
			if (min < input[i]) {
				pq.remove();
				pq.add(input[i]);
			}
		}
		
		while(!pq.isEmpty()) {
			answer.add(pq.remove());
		}
		return answer;
	}

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		int input[] = new int[n];
		for (int j = 0; j < n; j++) {
			input[j] = s.nextInt();
		}
		int k = s.nextInt();
		ArrayList<Integer> output = kLargest(input, k);
		for (int i : output) {
			System.out.println(i);
		}
		s.close();
	}
}
