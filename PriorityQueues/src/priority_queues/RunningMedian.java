package priority_queues;

//import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//class MinPQComparator implements Comparator<Integer>{
//
//	@Override
//	public int compare(Integer o1, Integer o2) {
//		// TODO Auto-generated method stub
//		if(o1 < o2){
//			return -1;
//		}else if(o1 > o2){
//			return 1;
//		}
//		return 0;
//	}
//
//}

//class MaxPQComparator implements Comparator<Integer>{
//
//	@Override
//	public int compare(Integer o1, Integer o2) {
//		// TODO Auto-generated method stub
//		if(o1 < o2){
//			return 1;
//		}else if(o1 > o2){
//			return -1;
//		}
//		return 0;
//	}
//
//}

public class RunningMedian {

	public static void runningMedian(int arr[]) {
		MinPQComparator minComp = new MinPQComparator();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(minComp);

		MaxPQComparator maxComp = new MaxPQComparator();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(maxComp);

		for (int i = 0; i < arr.length; i++) {

			if (maxHeap.isEmpty()) {
				maxHeap.add(arr[i]);
			} else if (arr[i] >= maxHeap.peek()) {
				minHeap.add(arr[i]);
			} else {
				maxHeap.add(arr[i]);
			}

			if (maxHeap.size() > minHeap.size() + 1) {
				int element = maxHeap.poll();
				minHeap.add(element);
			}

			if (minHeap.size() > maxHeap.size() + 1) {
				int element = minHeap.poll();
				maxHeap.add(element);
			}

			// calculating median
			if ((i + 1) % 2 != 0) { // odd number of element
				int median = maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
				System.out.println(median);
			} else {
				int median = (maxHeap.peek() + minHeap.peek()) / 2;
				System.out.println(median);
			}

		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		runningMedian(arr);
		s.close();
	}
}
