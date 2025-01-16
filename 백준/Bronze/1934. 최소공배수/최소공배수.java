import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int result = n * m / gcd(n, m);
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    static int gcd(int n, int m) {
        if (m == 0)
            return n;
        else
            return gcd(m, n % m);
    }
}