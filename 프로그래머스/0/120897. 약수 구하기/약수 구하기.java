import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        int[] numbers = new int[n + 1];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            numbers[i] = i;
        }
        for (int number : numbers) {
            if (number != 0 && n % number == 0)
                list.add(number);
        }
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}