class Solution {
    public int solution(int[] numbers, int n) {
        int answer = 0;
        boolean flag = true;
        while (flag) {
            for (int number : numbers) {
                if (answer <= n)
                    answer += number;
                else {
                    flag = false;
                    break;
                }
            }
        }
        return answer;
    }
}