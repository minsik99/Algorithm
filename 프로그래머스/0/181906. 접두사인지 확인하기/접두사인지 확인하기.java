class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 0;
        int str1 = my_string.length();
        int str2 = is_prefix.length();
        if (str1 < str2)
            return answer;
        int count = 0;
        for (int i = 0; i < str2; i++) {
            if (my_string.charAt(i) == is_prefix.charAt(i))
                count++;
        }
        if (str2 == count)
            answer++;
        return answer;
    }
}