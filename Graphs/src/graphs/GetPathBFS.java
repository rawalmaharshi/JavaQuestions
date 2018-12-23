package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GetPathBFS {
	
	private static ArrayList<Integer> getPathBFSHelper(int[][] edges, int sv, int ev, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.add(sv);
		visited[sv] = true;
		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, Integer> helperMap = new HashMap<>();
		
		while (!q.isEmpty()) {
			int curr = q.remove();
			
			for (int i = 0; i < edges.length; i++) {
				if (edges[curr][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
					helperMap.put(i, curr);
					
					if (i == ev) {
						break;	
					}
				}
			}
			
			if (!q.isEmpty() && helperMap.containsKey(ev)) {
				break;
			}
		}
		
		if (!q.isEmpty()) {
			int keyToSearch = ev;
			while (helperMap.containsKey(keyToSearch)) {
				ans.add(keyToSearch);
				keyToSearch = helperMap.get(keyToSearch);
			}
			ans.add(sv);
		}
		
		return ans;
	}
	
	public static ArrayList<Integer> getPathBFS(int edges[][], int sv, int ev) {
		boolean visited[] = new boolean[edges.length];
		return getPathBFSHelper (edges, sv, ev, visited);
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
		ArrayList<Integer> finalAns = getPathBFS(edges, startVertex, endVertex);
		if (finalAns != null) {
			for (int elem : finalAns) {
				System.out.print(elem + " ");
			}
		}
		s.close();
	}
}
