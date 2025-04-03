import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph[s].add(e);
			graph[e].add(s);
		}

		int minSum = Integer.MAX_VALUE;
		int answer = -1;

		for (int i = 1; i <= n; i++) {
			int sum = bfs(i);
			if (sum < minSum) {
				minSum = sum;
				answer = i;
			}
		}

		System.out.println(answer);
	}

	static int bfs(int start) {
		boolean[] visited = new boolean[n + 1];
		int[] dist = new int[n + 1];
		Queue<Integer> q = new LinkedList<>();

		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int current = q.poll();

			for (int next : graph[current]) {
				if (!visited[next]) {
					visited[next] = true;
					dist[next] = dist[current] + 1;
					q.add(next);
				}
			}
		}

		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += dist[i];
		}
		return sum;
	}
}
