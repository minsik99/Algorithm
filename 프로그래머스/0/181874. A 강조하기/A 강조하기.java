class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        for (char c : myString.toCharArray()) {
            if (c == 'a') 
                sb.append('A');
            else if ('A' < c && c <= 'Z') 
                sb.append((char) (c + 32));
            else
                sb.append(c);
        }
        return sb.toString();
    }
}