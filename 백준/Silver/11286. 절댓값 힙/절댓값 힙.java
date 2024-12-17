import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 연산의 개수 N, 정수 x

    출력 : 0이 주어진 횟수만큼 답을 출력

    [해결 과정]

    절댓값 힙을 구현하고 출력

    [슈도 코드]

    연산의 개수 N 저장
    우선순위 큐 선언
    절댓값 기준으로 정렬
    N만큼 반복
        0이면 출력
        1이면 푸시
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int first = Math.abs(o1);
            int second = Math.abs(o2);
            if (first == second) {
                return o1 > o2 ? 1 : -1;
            } else {
                return first - second;
            }
        });

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                if (queue.isEmpty()) {
                    sb.append('0').append('\n');
                } else {
                    sb.append(queue.poll()).append('\n');
                }
            } else {
                queue.add(number);
            }
        }

        System.out.print(sb);

        br.close();
    }
}