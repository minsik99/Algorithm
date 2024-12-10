import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 테스트케이스 T, 배추밭의 가로 M, 세로 N, 배추 위치의 개수 K, 위치 X, Y

    출력 : 최소의 배추흰지렁이 마리 수

    [해결 과정]

    최소이므로 bfs로 탐색

    [슈도 코드]

    입력값 저장
    bfs로 탐색
    상하좌우로 이동
    방문하지 않고 배추가 있다면 벌레 수 증가
 */

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 길이
            N = Integer.parseInt(st.nextToken()); // 세로 길이
            int K = Integer.parseInt(st.nextToken()); // 배추 개수

            map = new int[M][N];
            visited = new boolean[M][N];

            // 데이터 입력
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            int count = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}