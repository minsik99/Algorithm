import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : R, C, R 행 개수만큼 #, . 문자열

    출력 : 잔디 덩어리 개수

    [해결 과정]

    2차원 배열로 그래프를 만들고
    BFS로 순회하며 덩어리 카운트 증가

    [슈도 코드]

    입력값 저장
    2차원 배열로 그래프 저장
    반복문을 순회하며
        방문하지 않은 #을 만나면
            덩어리 카운트 증가
            방문 처리
 */

public class Main {
    // 방문 확인
    static boolean[][] visited;

    // 상하좌우 오프셋
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()); // 행
        int C = Integer.parseInt(st.nextToken()); // 열
        char[][] grasses = new char[R][C]; // 잔디
        visited = new boolean[R][C]; // 방문 확인
        int count = 0; // 덩어리 카운트

        // 데이터 삽입
        for (int i = 0; i < R; i++) {
            grasses[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && grasses[i][j] == '#') {
                    bfs(i, j, R, C, grasses);
                    count++;
                }
            }
        }

        System.out.print(count);

        br.close();
    }

    // BFS
    static void bfs(int x, int y, int R, int C, char[][] grasses) {
        // 큐로 구현
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true; // 방문 처리

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                // 범위 내에 있고 방문하지 않았을 때
                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    if (!visited[nx][ny] && grasses[nx][ny] == '#') {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}