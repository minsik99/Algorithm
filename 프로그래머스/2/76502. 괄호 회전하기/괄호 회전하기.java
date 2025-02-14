import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = 0;
        for (int i = 0; i < n; i ++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if(isValid(rotated))
                answer++;
        }
        return answer;
    }
    
    boolean isValid(String str) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        HashMap<Character, Character> map = new HashMap(Map.ofEntries(
            Map.entry(')', '('),
            Map.entry(']', '['),
            Map.entry('}', '{')
        ));
        for (char c : str.toCharArray()) {
            if (map.containsValue(c))
                stack.push(c);
            else if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}