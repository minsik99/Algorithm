import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 정점의 수 N, 간선의 수 M, 시작 정점 R

    출력 : i 번째 줄에 정점 i의 방문 순서

    [해결 과정]

    bfs로 탐색한다

    [슈도 코드]

    입력값 저장
    큐를 활용해 bfs 구현
    오름차순으로 정렬
 */

public class Main {
    static List<List<Integer>> graph;
    static int[] visited;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점 수
        int m = Integer.parseInt(st.nextToken()); // 간선 수
        int r = Integer.parseInt(st.nextToken()); // 시작 정점

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 데이터 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 오름차순으로 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new int[n + 1];

        bfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = count++;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.get(node)) {
                if (visited[neighbor] == 0) {
                    visited[neighbor] = count++;
                    queue.add(neighbor);
                }
            }
        }
    }
}