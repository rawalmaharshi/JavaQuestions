package graphs;

import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
	public int source;
	public int destination;
	public int weight;
	
	public Edge(int source, int destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}

public class KruskalAlgo {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

		
		Edge input[] = new Edge[E];
		for (int i = 0; i < input.length; i++) {
			int source = s.nextInt();
			int destination = s.nextInt();
			int weight = s.nextInt();
			
			input[i] = new Edge(source, destination, weight);
		}
		Arrays.sort(input);
		
		Edge output[] = new Edge[V-1];
		
		int parent[] = new int[V];
		//initialize parent to itself
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		
		int count = 0;
		int j = 0;
		
		while (count != V-1) {
			Edge currentEdge = input[j];
			int currSource = currentEdge.source;
			int currDest = currentEdge.destination;
			int currWeight = currentEdge.weight;
//			System.out.println("S: " + currSource + " D: " + currDest + " W: " + currWeight + " Count: " + count);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			int currSourceParent = findParent(currSource, parent);
			int currDestParent = findParent(currDest, parent);
			
			if (currSourceParent != currDestParent) {
				output[count] = new Edge(currSource, currDest, currWeight);
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
		s.close();
	}

	private static int findParent(int v, int[] parent) {
		if (parent[v] == v) {
			return v;
		}
		return findParent(parent[v], parent);
	}

}
