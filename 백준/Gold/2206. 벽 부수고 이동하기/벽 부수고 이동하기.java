import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		sb.append(bfs());

		System.out.print(sb);
	}

	private static int bfs() {
		Queue<Node> queue = new LinkedList<>();
		visited[0][0][0] = true;
		queue.add(new Node(0, 0, 1, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if (node.x == M - 1 && node.y == N - 1)
				return node.dist;

			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];

				if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
					if (map[ny][nx] == 0 && !visited[ny][nx][node.breakUsed]) {
						visited[ny][nx][node.breakUsed] = true;
						queue.add(new Node(nx, ny, node.dist + 1, node.breakUsed));
					} else if (map[ny][nx] == 1 && node.breakUsed == 0) {
						visited[ny][nx][1] = true;
						queue.add(new Node(nx, ny, node.dist + 1, 1));
					}
				}
			}
		}

		return -1;
	}

	static class Node {
		int x, y, dist, breakUsed;

		Node(int x, int y, int dist, int breakUsed) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.breakUsed = breakUsed;
		}
	}
}