import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int[][] lake; // 호수 거리
    static int[][] barn; // 헛간 거리
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[10][10];
        lake = new int[10][10];
        barn = new int[10][10];

        int lakeX = 0, lakeY = 0, barnX = 0, barnY = 0;

        // 입력값 저장
        for (int i = 0; i < 10; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 'L') {
                    lakeX = i;
                    lakeY = j;
                } else if (map[i][j] == 'B') {
                    barnX = i;
                    barnY = j;
                }
            }
        }

        // 각각 BFS 수행
        bfs(lakeX, lakeY, lake);
        bfs(barnX, barnY, barn);

        // 최소 거리 계산
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // 공통 접근 가능하며 빈 칸인 경우 거리 합산
                if (map[i][j] == '.' && lake[i][j] > 0 && barn[i][j] > 0) {
                    min = Math.min(min, lake[i][j] + barn[i][j]);
                }
            }
        }

        // 인접한 경우를 고려하여 -1
        System.out.print(min - 1);
    }

    static void bfs(int startX, int startY, int[][] dist) {
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        dist[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < 10 && ny < 10 && map[nx][ny] != 'R' && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}