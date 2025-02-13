import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int maxLength = Integer.MIN_VALUE;
		int start = 0, end = 0;
		int[] count = new int[100001];

		while (end < N) {
			int cur = numbers[end];
			count[cur]++;

			while (count[cur] > K) {
				count[numbers[start]]--;
				start++;
			}

			maxLength = Math.max(maxLength, end - start + 1);
			end++;
		}

		System.out.println(maxLength);
	}
}