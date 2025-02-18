import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}

		int[] findNumbers = new int[M];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			findNumbers[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;

		for (int i = 0; i < M; i++) {
			int target = findNumbers[i];
			int index = 0;

			for (int num : deque) {
				if (num == target) {
					break;
				}
				index++;
			}

			int leftMoves = index;
			int rightMoves = deque.size() - index;

			if (leftMoves <= rightMoves) {
				for (int j = 0; j < leftMoves; j++) {
					deque.addLast(deque.removeFirst());
					count++;
				}
			} else {
				for (int j = 0; j < rightMoves; j++) {
					deque.addFirst(deque.removeLast());
					count++;
				}
			}

			deque.removeFirst();
		}

		sb.append(count);

		System.out.print(sb);
	}
}