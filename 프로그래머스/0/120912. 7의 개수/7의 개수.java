class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for (int a : array) {
            String str = String.valueOf(a);
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '7')
                    answer++;
            }
        }
        return answer;
    }
}