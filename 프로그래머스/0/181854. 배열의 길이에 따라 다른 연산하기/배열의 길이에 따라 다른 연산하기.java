class Solution {
    public int[] solution(int[] arr, int n) {
        int length = arr.length;
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            answer[i] = arr[i];
        }
        if (length % 2 != 0) {
            for (int i = 0; i < length; i += 2) {
                answer[i] += n;
            }
        } else {
            for (int i = 1; i < length; i += 2) {
                answer[i] += n;
            } 
        }
        return answer;
    }
}