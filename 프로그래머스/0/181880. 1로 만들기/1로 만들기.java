class Solution {
    int answer = 0;
    public int solution(int[] num_list) {
        for (int num : num_list) {
            makeToOne(num);
        }
        return answer;
    }
    
    public void makeToOne(int n) {
        if (n == 1) return;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
                answer++;
            } else {
                n--;
                n /= 2;
                answer++;
            }
        }
    }
}