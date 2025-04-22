import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static List<Integer>[] tree;
	static boolean[] visited;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		visited = new boolean[n + 1];
		answer = new int[n + 1];
		tree = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			tree[n1].add(n2);
			tree[n2].add(n1);
		}

		bfs(1);

		for (int i = 2; i <= n; i++) {
			sb.append(answer[i]).append("\n");
		}

		System.out.println(sb);
	}

	private static void bfs(int n) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();

		queue.add(n);
		visited[n] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int next : tree[now]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
					answer[next] = now;
				}
			}
		}
	}
}
