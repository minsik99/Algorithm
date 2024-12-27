import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 정점 N, 간선 M, 양 끝점 u, v
    출력 : 연결 요소의 개수

    [해결 과정]

    무방향 그래프, dfs로 탐색
    dfs가 수행된 횟수 출력

    [슈도 코드]

    N 저장, M 저장
    list 그래프 저장
    visited 방문 배열 저장
    dfs 탐색
 */

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        A = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[u].add(v);
            A[v].add(u);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.print(count);

        br.close();
    }

    private static void dfs(int v) {
        if (visited[v]) return;
        visited[v] = true;
        for (int u : A[v]) {
            if (!visited[u]) dfs(u);
        }
    }
}