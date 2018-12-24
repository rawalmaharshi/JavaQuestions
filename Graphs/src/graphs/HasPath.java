package graphs;

import java.util.Scanner;

public class HasPath {
	
	private static boolean hasPathHelper (int [][] edges, int sv, int ev, boolean [] visited) {
		//base case
		if (edges[sv][ev] == 1) {
			return true;
		}
		
		visited[sv] = true;
		
		for (int i = 0; i < edges.length; i++) {
			if (edges[sv][i] == 1 && !visited[i]) {
				boolean res = hasPathHelper(edges, i, ev, visited);
				if (res) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean hasPath(int[][] edges, int sv, int ev) {
		boolean visited[] = new boolean[edges.length];
		return hasPathHelper(edges, sv, ev, visited);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

		int edges[][] = new int[V][V];
		for (int i = 0; i < E; i++) {
			int fv = s.nextInt();
			int sv = s.nextInt();
			edges[fv][sv] = 1;
			edges[sv][fv] = 1;
		}
		int startVertex = s.nextInt();
		int endVertex = s.nextInt();
		
		System.out.println(hasPath(edges, startVertex, endVertex));
		s.close();
	}

}
