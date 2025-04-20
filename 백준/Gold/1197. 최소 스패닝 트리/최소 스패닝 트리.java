import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static PriorityQueue<MyEdge> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.v));

		parent = new int[n + 1];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			queue.add(new MyEdge(s, e, v));
		}

		int useEdge = 0;
		int result = 0;

		while (useEdge < n - 1) {
			MyEdge current = queue.poll();

			if (find(current.s) != find(current.e)) {
				union(current.s, current.e);
				result += current.v;
				useEdge++;
			}
		}
		sb.append(result);

		System.out.println(sb);
	}

	private static void union(int s, int e) {
		s = find(s);
		e = find(e);

		if (s != e) {
			parent[e] = s;
		}
	}

	private static int find(int n) {
		if (n == parent[n]) {
			return n;
		}
		return parent[n] = find(parent[n]);
	}

}

class MyEdge {
	int s, e, v;

	MyEdge(int s, int e, int v) {
		this.s = s;
		this.e = e;
		this.v = v;
	}
}
