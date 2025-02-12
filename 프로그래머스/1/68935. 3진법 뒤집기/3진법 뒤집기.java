import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.push(n % 3);
            n /= 3;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        System.out.println(sb.toString());
        int[] arr = new int[sb.toString().length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sb.toString().charAt(i) - '0';
        }
        for (int i = 0; i < arr.length; i++) {
            answer += arr[i] * Math.pow(3, arr.length - i - 1);
        }
        return answer;
    }
}