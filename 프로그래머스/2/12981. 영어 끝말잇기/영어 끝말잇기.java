import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        char startWord = words[0].charAt(0);
        int turns = 0;
        for (String word : words) {
            if (!set.contains(word) && word.charAt(0) == startWord) {
                set.add(word);
                startWord = word.charAt(word.length() - 1);
                turns++;
            } else {
                answer[0] = turns % n + 1;
                answer[1] = turns / n + 1;
                break;
            }
        }
        return answer;
    }
}