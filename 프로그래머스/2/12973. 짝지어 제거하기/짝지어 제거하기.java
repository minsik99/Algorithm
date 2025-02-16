import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        if (stack.isEmpty())
            answer++;
        return answer;
    }
}