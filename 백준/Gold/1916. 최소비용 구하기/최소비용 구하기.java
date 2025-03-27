import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static List<MyEdge>[] list;
	static int[] dist;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		dist = new int[n + 1];
		visited = new boolean[n + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<MyEdge>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new MyEdge(end, weight));
		}

		st = new StringTokenizer(br.readLine());
		int startIndex = Integer.parseInt(st.nextToken());
		int endIndex = Integer.parseInt(st.nextToken());
		sb.append(dijkstra(startIndex, endIndex)).append("\n");

		System.out.println(sb);
	}

	private static int dijkstra(int start, int end) {
		PriorityQueue<MyEdge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
		pq.offer(new MyEdge(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			MyEdge nowEdge = pq.poll();
			if (!visited[nowEdge.vertex]) {
				visited[nowEdge.vertex] = true;

				for (MyEdge e : list[nowEdge.vertex]) {
					if (!visited[e.vertex] && dist[e.vertex] > dist[nowEdge.vertex] + e.weight) {
						dist[e.vertex] = dist[nowEdge.vertex] + e.weight;
						pq.add(new MyEdge(e.vertex, dist[e.vertex]));
					}
				}
			}
		}

		return dist[end];
	}
}

class MyEdge {
	int vertex, weight;

	MyEdge(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
}