import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int[] rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		parent = new int[V + 1];
		rank = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

		List<Edge> edges = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges.add(new Edge(u, v, weight));
		}

		Collections.sort(edges);

		int mstWeight = 0;
		int edgeCount = 0;

		for (Edge edge : edges) {
			if (union(edge.u, edge.v)) {
				mstWeight += edge.weight;
				edgeCount++;
				if (edgeCount == V - 1)
					break;
			}
		}

		sb.append(mstWeight);
		System.out.print(sb);
	}

	static class Edge implements Comparable<Edge> {
		int u, v, weight;

		Edge(int u, int v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Main.Edge other) {
			return Integer.compare(this.weight, other.weight);
		}
	}

	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA != rootB) {
			if (rank[rootA] < rank[rootB]) {
				parent[rootA] = rootB;
				return true;
			} else if (rank[rootA] > rank[rootB]) {
				parent[rootB] = rootA;
				return true;
			} else {
				parent[rootB] = rootA;
				rank[rootA]++;
				return true;
			}
		}
		return false;
	}

	static int find(int value) {
		if (parent[value] != value) {
			parent[value] = find(parent[value]);
		}
		return parent[value];
	}
}