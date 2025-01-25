import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int head = numbers[0] * numbers[1];
        int tail = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        return head > tail ? head : tail;
    }
}