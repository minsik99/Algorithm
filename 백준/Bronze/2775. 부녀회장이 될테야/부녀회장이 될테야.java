import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[][] dp = new int[15][15];
		for (int i = 0; i < 15; i++) {
			dp[i][1] = 1;
			dp[0][i] = i;
		}
		for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
			}
		}

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[k][n]);
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
