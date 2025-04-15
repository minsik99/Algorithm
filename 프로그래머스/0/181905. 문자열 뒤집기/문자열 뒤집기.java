class Solution {
    public String solution(String my_string, int s, int e) {
        String front = my_string.substring(0, s);
        String middle = new StringBuilder(my_string.substring(s, e + 1)).reverse().toString();
        String end = my_string.substring(e + 1);
        return front + middle + end;
    }
}