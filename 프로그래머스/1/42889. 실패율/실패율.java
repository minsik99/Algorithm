import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] players = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            players[stages[i]]++;
        }
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;
        for (int i = 1; i <= N; i++) {
            if (players[i] == 0)
                fails.put(i, 0.0);
            else {
                fails.put(i, players[i] / total);
                total -= players[i];
            }
        }
        return fails.entrySet().stream()
            .sorted(Comparator.comparingDouble(Map.Entry<Integer, Double>::getValue)
            .reversed().thenComparing(Map.Entry::getKey))
            .mapToInt(Map.Entry::getKey).toArray();
    }
}