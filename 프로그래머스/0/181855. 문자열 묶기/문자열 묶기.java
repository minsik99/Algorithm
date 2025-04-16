import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String str : strArr) {
            map.put(str.length(), map.getOrDefault(str.length(), 0) + 1);
        }
        int[] arr = new int[strArr.length];
        int idx = 0;
        for (int key : map.keySet()) {
            arr[idx++] = map.get(key);
        }
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
}