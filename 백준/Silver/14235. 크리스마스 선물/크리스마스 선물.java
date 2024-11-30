import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

/*
    [요구 사항]

    입력 : 1 <= n <= 5,000 횟수, 정수 a

    출력 : a가 0이면 출력, 아니라면 출력

    [해결 과정]

    충전한 a 중 가장 큰 수를 나누어주므로 우선순위 큐 활용

    [슈도 코드]

    입력값 저장
    선물을 저장할 큐 선언
    n만큼 반복하며
        0이 입력되면 큐에 팝
        아니라면 큐에 푸시
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 방문 횟수
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            String[] a = br.readLine().split(" "); // 명령어 추출

            // 0이라면 큐에서 팝
            if (Integer.parseInt(a[0]) == 0) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            }
            // 아니라면 큐에 푸시
            else {
                for (int j = 1; j <= Integer.parseInt(a[0]); j++) {
                    queue.add(Integer.parseInt(a[j]));
                }
            }
        }

        System.out.print(sb);

        br.close();
    }
}