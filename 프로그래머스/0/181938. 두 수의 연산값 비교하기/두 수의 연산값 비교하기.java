class Solution {
    public int solution(int a, int b) {
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(b);
        int x = Integer.parseInt(sb.toString());
        int y = 2 * a * b;
        return x > y ? x : y;
    }
}