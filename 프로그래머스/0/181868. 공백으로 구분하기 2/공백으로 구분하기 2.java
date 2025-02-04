import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        StringTokenizer st = new StringTokenizer(my_string);
        List<String> words = new ArrayList<>();
        
        while (st.hasMoreTokens()) {
            words.add(st.nextToken());
        }
        
        return words.toArray(new String[0]);
    }
}