import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int t = 0; t < commands.length; t++) {
            int i = commands[t][0], j = commands[t][1], k = commands[t][2];
            int[] copy = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(copy);
            answer[t] = copy[k - 1];
        }
        return answer;
    }
}