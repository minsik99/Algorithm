import java.io.*;
import java.util.*;

public class Main {
    static TreeSet<Integer>[] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        map = new TreeSet[N + 1]; 
        visited = new boolean[N + 1]; 

        for (int i = 1; i <= N; i++) {
            map[i] = new TreeSet<>(); 
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b); 
            map[b].add(a);
        }

        dfs(V);
        System.out.println();

        visited = new boolean[N + 1]; 
        bfs(V);

        br.close();
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            for (int neighbor : map[current]) { 
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    private static void dfs(int v) {
        System.out.print(v + " ");
        visited[v] = true;
        for (int neighbor : map[v]) { 
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}