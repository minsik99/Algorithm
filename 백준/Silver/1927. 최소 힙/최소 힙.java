import java.io.*;
import java.util.PriorityQueue;

/*
    [요구 사항]

    입력 : 1 <= N <= 100,000 연산의 개수와 정수 X

    출력 : X가 0이라면 가장 작은 값 출력 후 제거, 아니라면 배열에 추가

    [해결 과정]

    최소힙을 통해 해결

    [슈도 코드]

    최소힙을 선언 후
    입력되는 X에 따라 명령 수행
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 연산의 개수
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 연산 개수만큼 반복하며 명령 수행
        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(br.readLine());
            if (X == 0) {
                if (queue.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else {
                queue.add(X);
            }
        }

        System.out.print(sb);

        br.close();
    }
}