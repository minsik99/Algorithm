import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] visited = new int[26];
        Arrays.fill(visited, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (visited[idx] == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - visited[idx];
            }
            visited[idx] = i;
        }
        return answer;
    }
}