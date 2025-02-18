import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int time = 0, totalWatchTime = 0, jobIndex = 0, count = 0;
        int jobCount = jobs.length;
        while (count < jobCount) {
            while (jobIndex < jobCount && jobs[jobIndex][0] <= time) {
                pq.add(jobs[jobIndex]);
                jobIndex++;
            }
            if (!pq.isEmpty()) {
                int[] current = pq.poll();
                time += current[1];
                totalWatchTime += time - current[0];
                count++;
            } else {
                time = jobs[jobIndex][0];
            }
        }
        return totalWatchTime / jobCount;
    }
}