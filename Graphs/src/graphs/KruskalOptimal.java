package graphs;

import java.util.Arrays;
import java.util.Scanner;

class Edge1 implements Comparable<Edge1>{
	public int source;
	public int destination;
	public int weight;
	
	public Edge1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Edge1 o) {
		return this.weight - o.weight;
	}
}

public class KruskalOptimal {
	
	private static int findParent(int v, int[] parent) {
		if (parent[v] == v) {
			return v;
		}
		return findParent(parent[v], parent);
	}
	
	public static void kruskal (Edge1 input[], int V) {
		
		Arrays.sort(input);
		
		Edge1 output[] = new Edge1[V-1];
		
		int parent[] = new int[V];
		//initialize parent to itself
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		
		int count = 0;
		int j = 0;
		
		while (count != V-1) {
			Edge1 currentEdge1 = input[j];
			int currSource = currentEdge1.source;
			int currDest = currentEdge1.destination;

			int currSourceParent = findParent(currSource, parent);
			int currDestParent = findParent(currDest, parent);
			
			if (currSourceParent == currDestParent) {
				continue;
			} else {
				output[count] = currentEdge1;
				++count;
				parent[currSourceParent] = currDestParent;
			}
			j++;
		}
		
		for (int i = 0; i < output.length; i++) {
			if (output[i].source < output[i].destination) {
				System.out.println(output[i].source + " " + output[i].destination + " " + output[i].weight);
			} else {
				System.out.println(output[i].destination + " " + output[i].source + " " + output[i].weight);
			}
			
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

		
		Edge1 input[] = new Edge1[E];
		for (int i = 0; i < input.length; i++) {
			input[i] = new Edge1();
			
			input[i].source = s.nextInt();
			input[i].destination = s.nextInt();
			input[i].weight = s.nextInt();
		}
		kruskal(input, V);
		s.close();
	}

}
