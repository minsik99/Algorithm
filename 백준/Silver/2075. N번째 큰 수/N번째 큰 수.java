import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    [요구 사항]

    입력 : 1 <= N <= 1,500

    출력 : N번째 큰 수

    [해결 과정]

    N 제곱 형태의 행렬이 주어지므로 배열로 관리하면 시간 초과
    N 번째 큰 수를 찾기 위해선 정렬이 필요
    우선순위 큐를 활용해 데이터를 삽입

    [슈도 코드]

    자연수 N
    우선순위 큐 선언
    행렬의 데이터를 큐에 삽입
    N번째 수를 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            String[] numbers = br.readLine().split(" ");
            for (int j = 0; j < numbers.length; j++) {
                queue.add(Long.parseLong(numbers[j]));
            }
        }

        int cnt = 0;
        long res = 0;

        while (cnt < N) {
            cnt++;
            res = queue.poll();
        }

        System.out.println(res);
    }
}