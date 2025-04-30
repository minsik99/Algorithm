import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		dp = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
			dp[i][1] = i;
			dp[i][i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
				dp[i][j] %= 10007;
			}
		}
		sb.append(dp[n][k]);

		System.out.println(sb);
	}
}
