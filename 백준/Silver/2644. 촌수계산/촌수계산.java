import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 전체 사람 수 n, 촌수 계산할 번호

    출력 : 촌수, 없다면 -1

    [해결 과정]

    2차원 배열로 DFS로 탐색

    [슈도 코드]

    입력값 저장
    2차원 배열 선언
    입력받은만큼 반복 순회
        DFS로 탐색하기 위해 2차원 배열에 값 저장
        양방향 설정
    DFS 함수 시작
        카운트 출력

    DFS 함수
        방문 처리
        부모 노드가 자식 노드에 방문하면
            재귀 탈출하면서 동시에 탐색 종료하고 카운트 반환
        반복문을 순회하며 노드 탐색
            방문하지 않고 부모 자식 관계라면 재귀 호출
 */

public class Main {
    static int n; // 사람 수
    static int[][] map;
    static boolean[] visited;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 시작 노드
        int end = Integer.parseInt(st.nextToken()); // 종료 노드
        int m = Integer.parseInt(br.readLine()); // 관계 수

        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        // 데이터 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            // 양방향 설정
            map[parent][child] = 1;
            map[child][parent] = 1;
        }

        // DFS 함수 호출
        dfs(start, end ,0);

        System.out.print(answer);
    }

    static void dfs(int start, int end, int count) {
        visited[start] = true;

        if (start == end) {
            answer = count;
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i] && map[start][i] == 1) {
                dfs(i, end, count + 1);
            }
        }
    }
}