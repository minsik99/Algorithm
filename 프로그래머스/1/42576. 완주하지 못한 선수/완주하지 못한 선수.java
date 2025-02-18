import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> players = new HashMap<>();
        StringBuilder name = new StringBuilder();
        for (String s : participant) {
            players.put(s, players.getOrDefault(s, 0) + 1);
        }
        for (String c : completion) {
            if (players.containsKey(c)) {
                players.put(c, players.get(c) - 1);
            }
        }
        for (String p : players.keySet()) {
            if (players.get(p) > 0) {
                name.append(p);
                return name.toString();
            }
        }
        return name.toString();
    }
}