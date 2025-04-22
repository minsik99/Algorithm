import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static PriorityQueue<MyEdge> queue;
	static int n, sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		queue = new PriorityQueue<MyEdge>(Comparator.comparingInt(o -> o.v));

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			char[] tempc = st.nextToken().toCharArray();

			for (int j = 0; j < n; j++) {
				int temp = 0;
				if (tempc[j] >= 'a' && tempc[j] <= 'z') {
					temp = tempc[j] - 'a' + 1;
				} else if (tempc[j] >= 'A' && tempc[j] <= 'Z') {
					temp = tempc[j] - 'A' + 27;
				}
				sum += temp;
				if (i != j && temp != 0) {
					queue.add(new MyEdge(i, j, temp));
				}
			}
		}

		parent = new int[n];

		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		int useEdge = 0;
		int result = 0;

		while (!queue.isEmpty()) {
			MyEdge now = queue.poll();
			if (find(now.s) != find(now.e)) {
				union(now.s, now.e);
				result += now.v;
				useEdge++;
			}
		}

		if (useEdge == n - 1)
			sb.append(sum - result);
		else
			sb.append(-1);

		System.out.println(sb);
	}

	private static int find(int n) {
		if (n == parent[n])
			return n;
		else
			return parent[n] = find(parent[n]);
	}

	private static void union(int s, int e) {
		s = find(s);
		e = find(e);

		if (s != e) {
			parent[e] = s;
		}
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
