import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 세로 N, 가로 M, -와 ㅣ로 이루어진 문자열

    출력 : 방 장식에 필요한 판자의 개수

    [해결 과정]

    BFS를 통해 그래프 순환 탐색

    [슈도 코드]

    입력값 저장
    2차원 배열을 활용하여 그래프와 방문 배열 선언
    bfs로 그래프를 탐색하여 카운트 증가
 */

public class Main {
    static int N;
    static int M;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로
        int count = 0; // 장식 개수

        board = new char[N][M];
        visited = new boolean[N][M];

        // 데이터 저장
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);

        br.close();
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        char ch = board[x][y];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int k = 0; k < 2; k++) {
                int nx = currentX + dx[k];
                int ny = currentY + dy[k];

                // 같은 종류의 바닥 장식만 탐색
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && board[nx][ny] == ch) {
                    // 가로와 세로를 구분
                    if ((ch == '-' && k == 0) || (ch == '|' && k == 1)) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}