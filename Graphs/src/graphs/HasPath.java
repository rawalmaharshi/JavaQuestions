package graphs;

import java.util.Scanner;

public class HasPath {
	
	public static boolean hasPathHelper (int [][] edges, int sv, boolean [] visited) {
		visited[sv] = true;
		for (int i = 0; i < edges.length; i++) {
			if (edges[sv][i] == 1) {
				return true;
			} 
		}
		
		return false;
	}
	
	public static boolean hasPath(int[][] edges) {
		boolean visited[] = new boolean[edges.length];
		for (int i = 0; i < edges.length; i++) {
			if (!visited[i]) {
				return hasPathHelper(edges, i, visited);
			}
		}
		return false;
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
		System.out.println(hasPath(edges));;
		s.close();
	}

}
