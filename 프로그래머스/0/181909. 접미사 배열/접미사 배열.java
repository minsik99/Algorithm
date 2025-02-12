import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < my_string.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = my_string.length() - 1; j >= i; j--) {
                sb.append(my_string.charAt(j));
            }
            answer.add(sb.reverse().toString());
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
}