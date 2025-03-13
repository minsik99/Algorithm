class Solution {
    public int solution(int num, int k) {
        String number = String.valueOf(num);
        int index = number.indexOf(Character.forDigit(k, 10));
        return index == -1 ? -1 : index + 1;
    }
}