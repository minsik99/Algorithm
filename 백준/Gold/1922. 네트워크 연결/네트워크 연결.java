import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static List<Edge>[] graph;
	static boolean[] visited;
	static int N, M;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Edge(v, w));
			graph[v].add(new Edge(u, w));

		}

		int result = prim(1);

		System.out.println(result);
	}

	static int prim(int start) {
		PriorityQueue<Main.Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));

		int totalWeight = 0;

		while (!pq.isEmpty()) {
			Edge current = pq.poll();
			int vertax = current.vertax;

			if (visited[vertax])
				continue;

			visited[vertax] = true;
			totalWeight += current.weight;

			for (Edge next : graph[vertax]) {
				if (!visited[next.vertax]) {
					pq.add(next);
				}
			}
		}

		return totalWeight;
	}

	static class Edge implements Comparable<Edge> {
		int vertax, weight;

		Edge(int vertax, int weight) {
			this.vertax = vertax;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge other) {
			return Integer.compare(this.weight, other.weight);
		}
	}
}