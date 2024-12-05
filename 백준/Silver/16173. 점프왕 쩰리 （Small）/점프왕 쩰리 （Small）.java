import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : N x N 행렬. 승리 지점 : -1, 나머진 0 ~ 100 이하 정수

    출력 : 승리 지점에 도착하면 HaruHaru, 아니라며 Hing

    [해결 과정]

    2차원 배열로 그래프 구현 (0, 0) -> (N-1, N-1) 도착 여부
    BFS 탐색 사용 static 함수로 구현
    오프셋을 활용하여 좌표 이동 구현

    [슈도 코드]

    2 차원 배열로 입력값 저장 N * N, 같은 크기의 방문 배열 사용
    오프셋 선언 오른쪽, 아래쪽 방향
    bfs 메서드 호출

    bfs 함수 내에서 조건 (도착한 좌표값이 (-1, -1)인지 확인 후 HaruHaru 바로 출력)
    행과 열 개수만큼 이중 반복을 순회하며
        dx, dy 연산시 입력값 변수의 곱 활용
        방문 배열 체크
        좌표를 벗어날 경우 고려 x, continue
 */

public class Main {
    static int N;
    static int[][] square;
    static boolean[][] visited;
    // 오프셋 선언
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        square = new int[N][N];
        visited = new boolean[N][N];

        // 데이터 삽입
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // bfs 함수 호출
        bfs(0, 0);

        System.out.print("Hing");

        br.close();
    }

    // bfs 함수
    static void bfs(int x, int y) {
        // 승리 지점에 도착한다면 출력 후 종료
        if (square[x][y] == -1) {
            System.out.print("HaruHaru");
            System.exit(0);
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i] * square[x][y];
            int ny = y + dy[i] * square[x][y];

            if (nx < N && ny < N && !visited[nx][ny]) {
                visited[nx][ny] = true;
                bfs(nx, ny);
            }
        }
    }
}