import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    [요구 사항]

    입력 : 두 자연수 1 <= K <= N <= 5,000

    출력 : 요세푸스 순열 출력

    [해결 과정]

    큐를 활용하여 1부터 N까지 푸시
    하나씩 팝하면서 K번째가 아니라면 다시 푸시
    K번째라면 출력

    [슈도 코드]
    자연수 N, K 저장
    큐 선언
    1부터 N까지 큐에 저장
    큐가 빌 때까지 팝하면서
        K번째가 아니라면 다시 푸시
        맞다면 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new ArrayDeque<>();

        // 1부터 N까지 큐에 푸시
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        sb.append("<");

        // 큐가 빌 때까지 팝
        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            int front = queue.poll();
            if (cnt % M == 0) {
                if (queue.size() == 0) {
                    sb.append(front);
                } else {
                    sb.append(front).append(", ");
                }
                continue;
            }
            queue.add(front);
        }

        sb.append(">");

        System.out.println(sb);

        br.close();
    }
}