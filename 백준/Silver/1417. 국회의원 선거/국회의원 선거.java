import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 후보의 수
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙
        int vote = Integer.parseInt(br.readLine()); // 1번 후보의 표
        int count = 0; // 매수해야 하는 사람의 수

        // 나머지 후보의 표를 큐에 삽입
        for (int i = 0; i < N - 1; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        // 큐가 비어 있지 않고 1번 후보가 최다 득표자가 아닐 동안
        while (!queue.isEmpty() && queue.peek() >= vote) {
            int maxVotes = queue.poll(); // 가장 많은 표를 가진 후보
            if (maxVotes > 0) {
                queue.add(maxVotes - 1); // 표를 하나 줄임
                vote++; // 1번 후보의 표 하나 증가
                count++; // 매수 횟수 증가
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
