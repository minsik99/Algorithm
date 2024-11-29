import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

/*
    [요구 사항]

    입력 : 후보의 수 N, 각각 1번, 2번, 3번 표의 수

    출력 : 1번이 뽑히기 위해 매수해야 할 사람의 수

    [해결 과정]

    우선순위 큐를 통해 최대 힙으로
    카운트를 줄여가며 구한다

    [슈도 코드]

    입력값 차례대로 저장
    최대힙에 데이터 삽입
    카운트 변수 선언
    최대힙에서 하나씩 팝하면서
    팝한 값이 1번의 수보다 작을 때까지 카운트 증가
    이후 카운트 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 후보의 수
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙
        int count = 0;
        int vote = Integer.parseInt(br.readLine()); // 1번 후보의 표

        // 나머지 후보의 표를 큐에 삽입
        for (int i = 0; i < N - 1; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        // 큐가 비어 있지 않고 1번 후보가 최다 득표자가 아닐 동안
        while (!queue.isEmpty() && queue.peek() >= vote) {
            int maxVotes = queue.poll(); // 가장 많은 표를 가진 후보
            if (maxVotes > 0) {
                queue.add(maxVotes - 1);
                vote++;
                count++;
            }
        }

        System.out.print(count);

        br.close();
    }
}