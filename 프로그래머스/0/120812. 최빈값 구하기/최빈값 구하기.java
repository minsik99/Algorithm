import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> numbers = new HashMap<>();
        
        for (int n : array) {
            numbers.put(n, numbers.getOrDefault(n, 0) + 1);
        }
        
        int maxCnt = 0;
        for (Map.Entry<Integer, Integer> e : numbers.entrySet()) {
            if (maxCnt < e.getValue()) {
                maxCnt = e.getValue();
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : numbers.entrySet()) {
            if (e.getValue() == maxCnt) {
                list.add(e.getKey());
            }
        }
        
        if (list.size() > 1) 
            return -1;
        else
            return list.get(0);
    }
}