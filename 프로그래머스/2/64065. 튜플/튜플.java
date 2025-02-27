import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] tuples = s.substring(2, s.length() - 2).split("},\\{");
        
        Arrays.sort(tuples, Comparator.comparingInt(String::length));
        
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        
        for (String tuple : tuples) {
            for (String num : tuple.split(",")) {
                int number = Integer.parseInt(num);
                if(set.add(number))
                    result.add(number);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}