import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); 
        int M = Integer.parseInt(br.readLine()); 

        parent = new int[N + 1]; 
        for (int i = 1; i <= N; i++) {
            parent[i] = i; 
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int connected = Integer.parseInt(st.nextToken());
                if (connected == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] route = new int[M];
        for (int i = 0; i < M; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        int root = find(route[0]);
        for (int i = 1; i < M; i++) {
            if (find(route[i]) != root) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA; 
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); 
    }
}