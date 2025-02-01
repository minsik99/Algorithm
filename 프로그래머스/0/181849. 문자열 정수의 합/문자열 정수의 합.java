class Solution {
    public int solution(String num_str) {
        int answer = 0;
        char[] numbers = num_str.toCharArray();
        for (char number : numbers) {
            answer += (number - '0');
        }
        return answer;
    }
}