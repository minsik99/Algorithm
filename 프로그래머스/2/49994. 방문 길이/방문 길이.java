import java.util.*;

class Solution {
    public int solution(String dirs) {
        Map<Character, int[]> move = Map.of(
            'U', new int[]{0, 1}, 
            'D', new int[]{0, -1}, 
            'L', new int[]{-1, 0}, 
            'R', new int[]{1, 0}
        );
        int x = 0, y = 0;
        
        Set<String> visited = new HashSet<>();
        
        for (char dir : dirs.toCharArray()) {
            int nx = x + move.get(dir)[0];
            int ny = y + move.get(dir)[1];
            
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
           String path = Math.min(x, nx) + "," + Math.min(y, ny) + "," + Math.max(x, nx) + "," + Math.max(y, ny);
            visited.add(path);

            x = nx;
            y = ny;
        }

        return visited.size();
    }
}