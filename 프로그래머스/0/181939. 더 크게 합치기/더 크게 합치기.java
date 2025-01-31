class Solution {
    public int solution(int a, int b) {
        int x = Integer.parseInt(a + "" + b);
        int y = Integer.parseInt(b + "" + a);
        return x >= y ? x : y;
    }
}