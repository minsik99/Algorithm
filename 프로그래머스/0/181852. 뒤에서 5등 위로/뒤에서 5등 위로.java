import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 5; i < num_list.length; i++) {
            list.add(num_list[i]);
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
}