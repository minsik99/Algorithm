class Solution {
    public int solution(int n) {
        int fac = 1;
        int i = 1;
        while (true) {
            fac *= i;
            if (fac > n) break;
            i++;
        }
        return i - 1;
    }
}