import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int K = Integer.parseInt(br.readLine());

		int sum = 0;

		ArrayDeque<Integer> stack = new ArrayDeque<>();

		for (int k = 0; k < K; k++) {
			int input = Integer.parseInt(br.readLine());

			if (input == 0) {
				stack.pop();
			} else {
				stack.push(input);
			}
		}

		for (int s : stack) {
			sum += s;
		}

		sb.append(sum);

		System.out.print(sb);
	}
}