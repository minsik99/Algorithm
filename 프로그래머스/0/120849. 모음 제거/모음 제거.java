class Solution {
    public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        
        for (char c : my_string.toCharArray()) {
            boolean isVowel = false;
            for (char v : vowels) {
                if (c == v) {
                    isVowel = true;
                    break;
                }
            }
            if (!isVowel) {
                answer.append(c);
            }
        }
        
        return answer.toString();
    }
}