class Solution {
    public String solution(String n_str) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (char c : n_str.toCharArray()) {
            if (c == '0')
                idx++;
            else
                break;
        }
        for (int i = idx; i < n_str.length(); i++) {
            sb.append(n_str.charAt(i));
        }
        return sb.toString();
    }
}