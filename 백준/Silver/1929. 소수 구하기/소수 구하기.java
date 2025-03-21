import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] isPrime;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		isPrime = new boolean[n + 1];

		checkPrime();

		for (int i = m; i < isPrime.length; i++) {
			if (isPrime[i])
				sb.append(i).append("\n");
		}

		System.out.println(sb);
	}

	private static void checkPrime() {
		for (int i = 2; i <= n; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i * i <= n; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}
}