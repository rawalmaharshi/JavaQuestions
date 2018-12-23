package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AllConnectedComponents {
	
	private static ArrayList<Integer> allComponentsHelper (int [][] edges, int currVertex, ArrayList<Integer> smallAns, boolean[] visited) {
		smallAns.add(currVertex);
		visited[currVertex] = true;
		
		for (int i = 0; i < edges.length; i++) {
			if (edges[currVertex][i] == 1 && !visited[i]) {
				allComponentsHelper(edges, i, smallAns, visited);
			}
		}
				
		Collections.sort(smallAns);
		return smallAns;
	}
	
	public static ArrayList<ArrayList<Integer>> allConnectedComponents(int [][] edges) {
		boolean visited[] = new boolean[edges.length];
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		
		for (int i = 0; i < edges.length; i++) {
			if (!visited[i]) {
				ArrayList<Integer> smallArray = new ArrayList<>();
				smallArray = allComponentsHelper (edges, i, smallArray, visited);
				ans.add(smallArray);
			}
		}
		
		return ans;
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
		
		ArrayList<ArrayList<Integer>> finalAns = allConnectedComponents(edges);
		for (int i = 0; i < finalAns.size(); i++) {
			for (int elem : finalAns.get(i)) {
				System.out.print(elem + " ");
			}
			System.out.println();
		}
		s.close();
	}

}
