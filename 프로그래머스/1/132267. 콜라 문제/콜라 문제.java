class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {  
            int newCoke = (n / a) * b;
            answer += newCoke; 
            n = (n % a) + newCoke;
        }
        
        return answer;
    }
}