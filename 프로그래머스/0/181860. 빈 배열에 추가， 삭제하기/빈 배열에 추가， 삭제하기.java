import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (flag[i]) {
                for (int j = 0; j < arr[i] * 2; j++) {
                    deque.addLast(arr[i]);
                }
            } else {
                for (int j = 0; j < arr[i]; j++) {
                    deque.removeLast();
                }
            }
        }
        return deque.stream().mapToInt(Integer::intValue).toArray();
    }
}