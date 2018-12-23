package graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class GetPathDFS {
	
	private static ArrayList<Integer> getPathDFSHelper(int[][] edges, int sv, int ev, boolean[] visited) {
		//base case
		if (sv == ev) {
			ArrayList<Integer> ans = new ArrayList<>();
			ans.add(ev);
			return ans;
		}
		
		visited[sv] = true;
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < edges.length; i++) {
			if (edges[sv][i] == 1 && !visited[i]) {
				ans = getPathDFSHelper(edges, i, ev, visited);
				if (ans != null) {
					ans.add(sv);
					return ans;
				}
			}
		}
		
		return null;
	}
	
	public static ArrayList<Integer> getPathDFS(int edges[][], int sv, int ev) {
		boolean visited[] = new boolean[edges.length];
		return getPathDFSHelper (edges, sv, ev, visited);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

		int edges[][] = new int[V][V];
		for (int i = 0; i < E; i++) {
			int sv = s.nextInt();
			int ev = s.nextInt();
			edges[sv][ev] = 1;
			edges[ev][sv] = 1;
		}
		int startVertex = s.nextInt();
		int endVertex = s.nextInt();
		ArrayList<Integer> finalAns = getPathDFS(edges, startVertex, endVertex);
		if (finalAns != null) {
			for (int elem : finalAns) {
				System.out.print(elem + " ");
			}
		}
		s.close();
	}
}
