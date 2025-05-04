import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] split = myStr.split("[abc]");
        List<String> result = new ArrayList<>();

        for (String s : split) {
            if (!s.isEmpty()) {
                result.add(s);
            }
        }

        if (result.isEmpty()) {
            return new String[] {"EMPTY"};
        }

        return result.toArray(new String[0]);
    }
}
