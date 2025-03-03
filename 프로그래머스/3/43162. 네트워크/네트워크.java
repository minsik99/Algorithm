import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(i, computers, visited);
                answer++;
            }
        }
        return answer;
    }
    
    void bfs (int node, int[][] computers, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for (int next = 0; next < computers[current].length; next++) {
                if (computers[current][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}