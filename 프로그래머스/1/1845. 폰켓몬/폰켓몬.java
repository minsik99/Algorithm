import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int pick = nums.length / 2;
        for (int num : nums) {
            set.add(num);
        }
        if (set.size() < pick) 
            return set.size();
        else
            return pick;
    }
}