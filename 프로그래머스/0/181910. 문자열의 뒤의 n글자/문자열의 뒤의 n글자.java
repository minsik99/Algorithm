class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder(my_string);
        sb.reverse();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append(sb.toString().charAt(i));
        }
        return answer.reverse().toString();
    }
}