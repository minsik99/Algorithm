import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 컴퓨터 수, 컴퓨터 쌍의 수, 번호 쌍

    출력 : 1번 컴퓨터를 통해 바이러스에 걸리게 되는 컴퓨터의 수

    [해결 과정]

    컴퓨터는 그래프로 구현하여 dfs로 탐색
    시작을 제외한 방문 노드 수 출력

    [슈도 코드]

    입력값 저장
    인접 리스트로 그래프 저장
    bfs로 탐색
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int m = Integer.parseInt(br.readLine()); // 컴퓨터의 쌍

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 데이터 입력
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n + 1];
        int count = bfs(1, graph, visited);

        System.out.print(count);
    }

    private static int bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count;
    }
}