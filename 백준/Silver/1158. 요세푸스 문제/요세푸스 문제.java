import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore.Entry;
import java.time.Year;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		sb.append("<");

		int idx = 0;
		while (queue.size() > 1) {
			idx++;
			int current = queue.poll();
			if (idx % k == 0) {
				sb.append(current).append(", ");
			} else {
				queue.add(current);
			}
		}

		sb.append(queue.poll()).append(">");

		System.out.print(sb);
	}
}