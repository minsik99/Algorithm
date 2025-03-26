import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        Set<Integer> removeSet = new HashSet<>();
        for (int index : indices) {
            removeSet.add(index);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            if (!removeSet.contains(i)) {
                sb.append(my_string.charAt(i));
            }
        }

        return sb.toString();
    }
}