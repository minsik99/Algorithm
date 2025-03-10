class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int n1 = intervals[0][1] - intervals[0][0] + 1;
        int n2 = intervals[1][1] - intervals[1][0] + 1;
        int[] answer = new int[n1 + n2];
        int idx = 0;
        for (int i = intervals[0][0]; i <= intervals[0][1]; i++) {
            answer[idx++] = arr[i];
        }
        for (int i = intervals[1][0]; i <= intervals[1][1]; i++) {
            answer[idx++] = arr[i];
        }
        return answer;
    }
}