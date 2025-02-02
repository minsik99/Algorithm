class Solution {
    public int solution(int[] num_list) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        for (int number : num_list) {
            if (number % 2 != 0)
                odd.append(number);
            else
                even.append(number);
        }
        return Integer.parseInt(odd.toString()) + Integer.parseInt(even.toString());
    }
}