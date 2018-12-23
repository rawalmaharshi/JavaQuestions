package graphs;

import java.util.Scanner;

public class IsConnected {
	
	private static boolean isConnectedHelper (int edges[][], int sv, boolean visited[]) {
		visited[sv] = true;
		
		for (int i = 0; i < edges.length; i++) {
			if (edges[sv][i] == 1 && !visited[i]) {
				isConnectedHelper(edges, i, visited);
			}
		}
		
		for (boolean elem : visited) {
			if (elem == false) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isConnected (int edges[][]) {
		boolean visited[] = new boolean[edges.length];
		return isConnectedHelper (edges, 0, visited);
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
		
		System.out.println(isConnected(edges));;
		s.close();
	}

}
