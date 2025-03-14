class Solution {
    public String solution(int age) {
        StringBuilder answer = new StringBuilder();
        String str = String.valueOf(age);
        for (char c : str.toCharArray()) {
            answer.append((char) (c + 49));
        }
        return answer.toString();
    }
}