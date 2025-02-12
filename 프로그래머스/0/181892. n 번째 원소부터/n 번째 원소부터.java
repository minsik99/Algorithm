import java.util.ArrayList;

class Solution {
    public int[] solution(int[] num_list, int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = n - 1; i < num_list.length; i++) {
            answer.add(num_list[i]);
        }
        return answer.stream().mapToInt(x -> x).toArray();
    }
}