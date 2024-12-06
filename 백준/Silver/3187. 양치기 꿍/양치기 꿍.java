import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 가로 R, 세로 C, 문자열

    출력 : 살아남은 양과 늑대 수

    [해결 과정]

    DFS로 탐색하여 해결
    같은 영역 내 더 많은 수에 따라 양만 혹은 늑대만 카운트 증가

    [슈도 코드]

    입력값 저장
    dfs 함수
        방문 처리
        범위, 방문 여부에 따라 탐색 중단 후 방향을 바꾼다
        재귀 호출
 */

public class Main {
    static int R;
    static int C;
    static char[][] square;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int sheepCount = 0;
    static int wolfCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 가로
        C = Integer.parseInt(st.nextToken()); // 세로

        square = new char[R][C];
        visited = new boolean[R][C];

        // 데이터 삽입
        for (int i = 0; i < R; i++) {
            square[i] = br.readLine().toCharArray();
        }

        int sheep = 0;
        int wolf = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (square[i][j] != '#' && !visited[i][j]) {
                    sheepCount = 0;
                    wolfCount = 0;

                    dfs(i, j);

                    if (sheepCount > wolfCount) {
                        sheep += sheepCount;
                    } else {
                        wolf += wolfCount;
                    }
                }
            }
        }

        System.out.print(sheep + " " + wolf);
    }

    // DFS
    static void dfs(int x, int y) {
        visited[x][y] = true; // 방문 처리

        // 해당 위치의 동물이 있다면 카운트 증가
        if (square[x][y] == 'v') {
            wolfCount++;
        }
        if (square[x][y] == 'k') {
            sheepCount++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 해당 범위 이내이거나 방문하지 않았을 때
            if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[nx][ny] && square[nx][ny] != '#') {
                dfs(nx, ny);
            }
        }
    }
}