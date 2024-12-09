import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 도시 개수
        int M = Integer.parseInt(st.nextToken()); // 도로 개수
        int K = Integer.parseInt(st.nextToken()); // 목표 거리
        int X = Integer.parseInt(st.nextToken()); // 출발 도시
        
        // 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 도로 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
        }
        
        // 거리 저장 배열 초기화 (-1로 초기화)
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);
        distance[X] = 0; // 출발 도시의 거리는 0
        
        // BFS 초기화
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        
        // BFS 탐색
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph.get(current)) {
                if (distance[next] == -1) { // 방문하지 않은 도시
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }
        
        // 거리 K인 도시 찾기
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                result.add(i);
            }
        }
        
        // 결과 출력
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            result.forEach(System.out::println);
        }
    }
}