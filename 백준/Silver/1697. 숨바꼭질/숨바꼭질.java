import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 수빈이 위치 N, 동생 위치 K

    출력 : 수빈이가 동생을 찾는 가장 빠른 시간

    [해결 과정]

    bfs로 탐색하여 최단 시간 측정
    방문 배열에 시간을 저장
    입력값의 최대 크기인 100000으로 크기 설정

    [슈도 코드]

    입력값 저장
    방문하지 않은 노드를 순회하며
    도착할 때의 시간을 반환
 */

public class Main {
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int K = Integer.parseInt(st.nextToken()); // 동생 위치

        System.out.print(bfs(N, K));
    }

    private static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            // 동생 위치라면 시작값 1을 뺀 값 반환
            if (cur == end) {
                return visited[cur] - 1;
            }

            // 규칙에 따라 다음 노드를 이동하며 범위 내이며 방문하지 않았다면 푸시
            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (next >= 0 && next <= 100000 && visited[next] == 0) {
                    visited[next] = visited[cur] + 1;
                    queue.add(next);
                }
            }
        }
        return -1;
    }
}