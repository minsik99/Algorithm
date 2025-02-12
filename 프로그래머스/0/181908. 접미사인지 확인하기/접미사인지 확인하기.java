class Solution {
    public int solution(String my_string, String is_suffix) {
        StringBuilder sb = new StringBuilder(my_string);
        sb.reverse();
        StringBuilder sb2 = new StringBuilder(is_suffix);
        sb2.reverse();
        return sb.toString().startsWith(sb2.toString()) ? 1 : 0;
    }
}