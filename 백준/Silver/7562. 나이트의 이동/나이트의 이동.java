import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 테스트 케이스 개수, 체스판 한 변의 길이, 나이트 위치, 목적지

    출력 : 목적지에 도착할 수 있는 최솟값

    [해결 과정]

    최소의 경우의 수로 이동해야 하므로 bfs로 탐색한다
    나이트가 이동하는 8가지 방향을 배열로 선언해서 활용

    [슈도 코드]

    입력값 저장
    나이트가 이동할 수 있는 방향 배열 선언
    bfs함수 큐로 구현
        큐에 들어가는 값은 현재 좌표값과 이동 횟수
 */

public class Main {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 체스판 크기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            sb.append(bfs(n, X, Y, endX, endY)).append("\n");
        }

        System.out.print(sb);
    }

    // bfs 함수
    private static int bfs(int n, int X, int Y, int endX, int endY) {
        if (X == endX && Y == endY) {
            return 0;
        }

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{X, Y, 0});
        visited[X][Y] = true;

        // 탐색 시작
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int moves = current[2];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    if (nx == endX && ny == endY) {
                        return moves + 1;
                    }
                    queue.add(new int[]{nx, ny, moves + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}