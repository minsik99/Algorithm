import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static char[][] map;

    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        map = new char[n][m];
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];
        
        // 문자열을 char 배열로 변환
        for (int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'S') start = new int[]{i, j};
                else if (map[i][j] == 'L') lever = new int[]{i, j};
                else if (map[i][j] == 'E') exit = new int[]{i, j};
            }
        }
        
        // 시작점에서 레버까지 BFS
        int dist1 = bfs(start, lever);
        if (dist1 == -1) return -1;

        // 레버에서 출구까지 BFS
        int dist2 = bfs(lever, exit);
        if (dist2 == -1) return -1;
        
        return dist1 + dist2;
    }
    
    static int bfs(int[] start, int[] end) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dist = cur[2];
            
            if (x == end[0] && y == end[1]) return dist;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && 
                    !visited[nx][ny] && map[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return -1;
    }
}