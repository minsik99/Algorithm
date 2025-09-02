class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        StringBuilder reversed = new StringBuilder();
        int n = food.length;
        int idx = 0;
        for (int i = 1; i < n; i++) {
            idx++;
            if (food[i] < 2) {
                continue;
            }
            for (int j = 0; j < food[i] / 2; j++) {
                answer.append(idx);
                reversed.append(idx);
            }
        }
        answer.append(0);
        answer.append(reversed.reverse());
        return answer.toString();
    }
}