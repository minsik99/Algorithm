class Solution {
    public int solution(int n) {
        return n - findPrime(n) - 1;
    }
    
    private int findPrime(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n + 1];
        
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        for (int i = 2; i <= n; i++) {
            if (isPrime[i])
                count++;
        }
        
        return count;
    }
}