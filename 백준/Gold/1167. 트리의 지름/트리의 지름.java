import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 트리 정점의 개수 V, 간선
    출력 : 트리의 지름

    [해결 과정]

    트리의 임의의 두 점 사이의 거리 중 가장 긴 것
    가중치가 있는 노드이므로 클래스로 저장
    bfs 탐색 후 각 노드의 거리 배열에 저장 후 최댓값 반환

    [슈도 코드]

    N 저장, M 저장
    map 인접 리스트로 저장
    visited 방문 배열 저장
    distance 거리 배열 저장
    bfs 수행
 */

public class Main {
    static ArrayList<Edge>[] map;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while (true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) break;
                int v = Integer.parseInt(st.nextToken());
                map[s].add(new Edge(e, v));
            }
        }

        distance = new int[N + 1];
        visited = new boolean[N + 1];

        bfs(1);
        int Max = 1;
        for (int i = 2; i <= N; i++) {
            if (distance[Max] < distance[i]) {
                Max = i;
            }
        }

        distance = new int[N + 1];
        visited = new boolean[N + 1];
        bfs(Max);

        Arrays.sort(distance);
        System.out.print(distance[N]);

        br.close();
    }

    private static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Edge edge : map[now]) {
                int e = edge.e;
                int v = edge.value;
                if (!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now] + v;
                }
            }
        }
    }
}

class Edge {
    int e;
    int value;

    public Edge(int e, int value) {
        this.e = e;
        this.value = value;
    }
}