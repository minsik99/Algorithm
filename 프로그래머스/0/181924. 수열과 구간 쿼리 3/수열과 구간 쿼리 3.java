class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i];
        }
        for (int t = 0; t < queries.length; t++) {
            int i = queries[t][0];
            int j = queries[t][1];
            
            int temp = answer[i];
            answer[i] = answer[j];
            answer[j] = temp;
        }
        return answer;
    }
}