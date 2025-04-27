import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] tree;
	static StringBuilder answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		tree = new int[26][2];

		answer = new StringBuilder();

		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
			int node = tmp[0].charAt(0) - 'A';
			char left = tmp[1].charAt(0);
			char right = tmp[2].charAt(0);

			if (left == '.') {
				tree[node][0] = -1;
			} else {
				tree[node][0] = left - 'A';
			}

			if (right == '.') {
				tree[node][1] = -1;
			} else {
				tree[node][1] = right - 'A';
			}
		}

		preOrder(0);
		answer.append("\n");
		inOrder(0);
		answer.append("\n");
		postOrder(0);

		System.out.println(answer);
	}

	private static void preOrder(int now) {
		if (now == -1)
			return;
		answer.append((char) (now + 'A'));
		preOrder(tree[now][0]);
		preOrder(tree[now][1]);
	}

	private static void inOrder(int now) {
		if (now == -1)
			return;
		inOrder(tree[now][0]);
		answer.append((char) (now + 'A'));
		inOrder(tree[now][1]);
	}

	private static void postOrder(int now) {
		if (now == -1)
			return;
		postOrder(tree[now][0]);
		postOrder(tree[now][1]);
		answer.append((char) (now + 'A'));
	}
}
