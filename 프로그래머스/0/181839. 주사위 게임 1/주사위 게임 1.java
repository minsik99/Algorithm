import java.util.*;

class Solution {
    public int solution(int a, int b) {
        if ((a + b) % 2 == 1) {
            return 2 * (a + b);
        } else {
            if (a % 2 == 1) {
                return a * a + b * b;
            } else {
                return Math.abs(a - b);
            }
        }
    }
}