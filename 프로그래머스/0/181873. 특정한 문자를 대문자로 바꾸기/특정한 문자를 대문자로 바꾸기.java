class Solution {
    public String solution(String my_string, String alp) {
        StringBuilder sb = new StringBuilder();
        for (char c : my_string.toCharArray()) {
            if (c == alp.charAt(0)) 
                sb.append((char) (c - 32));
            else
                sb.append(c);
        }
        return sb.toString();
    }
}