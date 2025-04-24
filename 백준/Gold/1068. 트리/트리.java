import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] tree;
	static boolean[] visited;
	static int answer;
	static int deleteNode;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n];
		visited = new boolean[n];

		int root = 0;

		for (int i = 0; i < n; i++) {
			tree[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int p = Integer.parseInt(st.nextToken());

			if (p != -1) {
				tree[i].add(p);
				tree[p].add(i);
			} else {
				root = i;
			}
		}

		deleteNode = Integer.parseInt(br.readLine());

		if (deleteNode == root) {
			sb.append(0);
		} else {
			dfs(root);
			sb.append(answer);
		}

		System.out.println(sb);
	}

	private static void dfs(int node) {
		visited[node] = true;
		int cNode = 0;

		for (int next : tree[node]) {
			if (!visited[next] && next != deleteNode) {
				cNode++;
				dfs(next);
			}
		}

		if (cNode == 0) {
			answer++;
		}
	}
}
