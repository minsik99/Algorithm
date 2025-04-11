class Solution {
    public int[] solution(int[] arr) {
        int length = arr.length;
        int powerOfTwo = 1;
        
        while (powerOfTwo < length) {
            powerOfTwo *= 2;
        }
        
        int[] answer = new int[powerOfTwo];
        for (int i = 0; i < length; i++) {
            answer[i] = arr[i];
        }

        return answer;
    }
}