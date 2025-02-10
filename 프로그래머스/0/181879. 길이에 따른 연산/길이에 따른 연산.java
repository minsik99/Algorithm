class Solution {
    public int solution(int[] num_list) {
        int answer = 1;
        if (num_list.length < 11) {
            for (int num : num_list) {
                answer *= num;
            }
        } else {
            answer--;
            for (int num : num_list) {
                answer += num;
            }
        }
        return answer;
    }
}