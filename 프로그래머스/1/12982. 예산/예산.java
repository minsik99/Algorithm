import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int idx = 0;
        while (idx < d.length && budget >= d[idx]) { 
            budget -= d[idx++];
            answer++;
        }
        return answer;
    }
}