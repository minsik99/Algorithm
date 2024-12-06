import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 5 * 5의 숫자판

    출력 : 만들 수 있는 서로 다른 여섯 자리의 수들의 개수

    [해결 과정]

    DFS로 탐색하며
    셋으로 중복 제거

    [슈도 코드]

    입력값 저장
    DFS로 탐색하며 문자열로 숫자 저장
    셋으로 중복 제거
 */

public class Main {
    static int[][] board = new int[5][5];
    static Set<String> set = new HashSet<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 칸에서 DFS 시작
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, ""); // 초기 길이 0, 빈 문자열로 시작
            }
        }

        // 결과 출력
        System.out.println(set.size());
    }

    // DFS 탐색
    static void dfs(int x, int y, int depth, String number) {
        // 여섯 자리 숫자가 완성되면 Set에 저장
        if (depth == 6) {
            set.add(number);
            return;
        }

        // 상하좌우 탐색
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 범위 내에서만 이동
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                dfs(nx, ny, depth + 1, number + board[nx][ny]);
            }
        }
    }
}