import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<int[]>[] graph;
    static long[] values; 
    static boolean[] visited; 
    static long lcm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        long gcdProduct = 1; 

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b, p, q});
            graph[b].add(new int[]{a, q, p});

            gcdProduct *= (p * q) / gcd(p, q); 
        }

        values = new long[N];
        visited = new boolean[N];

        values[0] = gcdProduct;
        dfs(0);

        long gcdAll = values[0];
        for (int i = 1; i < N; i++) {
            gcdAll = gcd(gcdAll, values[i]);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(values[i] / gcdAll + " ");
        }
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int[] edge : graph[node]) {
            int next = edge[0];
            int p = edge[1];
            int q = edge[2];

            if (!visited[next]) {
                values[next] = values[node] * q / p;
                dfs(next);
            }
        }
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}