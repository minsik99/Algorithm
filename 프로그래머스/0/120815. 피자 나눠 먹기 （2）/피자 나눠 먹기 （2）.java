class Solution {
    public int solution(int n) {
        int lcm = (n * 6) / gcd(n, 6);
        return lcm / 6;
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}