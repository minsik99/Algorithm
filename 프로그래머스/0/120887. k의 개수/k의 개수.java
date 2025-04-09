class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for (int idx = i; idx <= j; idx++) {
            StringBuilder sb = new StringBuilder();
            sb.append(idx);
            for (char c : sb.toString().toCharArray()) {
                if (c - '0' == k)
                    answer++;
            }
        }
        return answer;
    }
}