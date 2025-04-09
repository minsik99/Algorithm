import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] towers = new int[n];
		int[] answer = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			towers[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && towers[stack.peek()] < towers[i]) {
				stack.pop();
			}

			if (!stack.isEmpty()) {
				answer[i] = stack.peek() + 1;
			}

			stack.push(i);
		}

		for (int i : answer) {
			sb.append(i).append(" ");
		}

		System.out.println(sb);
	}
}
