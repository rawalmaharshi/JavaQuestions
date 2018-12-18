package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSTraversal {
	
	private static void BFSPrintHelper (int edges[][], int startingVertex, boolean isVisited[]) {
		Queue<Integer> q = new LinkedList<>();
		q.add(startingVertex);
		isVisited[startingVertex] = true;
		
		while(!q.isEmpty()) {
			int curr = q.remove();
			System.out.print(curr + " ");
			
			for (int i = 0; i < edges.length; i++) {
				if (edges[curr][i] == 1 && !isVisited[i]) {
					q.add(i);
					isVisited[i] = true;
				}
			}
		}
	}
	
	public static void BFSPrint (int edges[][]) {
		boolean isVisited[] = new boolean[edges.length];
		for (int i = 0; i < edges.length; i++) {
			if (!isVisited[i]) {
				BFSPrintHelper(edges, 0, isVisited);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

		int edges[][] = new int[V][V];
		for (int i = 0; i < E; i++) {
			int firstVertex = s.nextInt();
			int secondVertex = s.nextInt();
			edges[firstVertex][secondVertex] = 1;
			edges[secondVertex][firstVertex] = 1;
		}
		BFSPrint(edges);
		s.close();
	}
}
