import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] tree;
	static int[] depth;
	static int[] parent;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			tree[s].add(e);
			tree[e].add(s);
		}

		depth = new int[n + 1];
		parent = new int[n + 1];
		visited = new boolean[n + 1];

		bfs(1);

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int lca = getLca(a, b);
			sb.append(lca);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static int getLca(int a, int b) {
		if (depth[a] < depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		while (depth[a] != depth[b]) {
			a = parent[a];
		}
		while (a != b) {
			a = parent[a];
			b = parent[b];
		}
		return a;
	}

	private static void bfs(int node) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(node);
		visited[node] = true;
		int level = 1;
		int now_size = 1;
		int count = 0;
		while (!queue.isEmpty()) {
			int now_node = queue.poll();
			for (int next : tree[now_node]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
					parent[next] = now_node;
					depth[next] = level;
				}
			}
			count++;
			if (count == now_size) {
				count = 0;
				now_size = queue.size();
				level++;
			}
		}
	}
}
