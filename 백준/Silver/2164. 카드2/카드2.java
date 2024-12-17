import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 정수 N

    출력 : 마지막에 남는 수

    [해결 과정]

    N까지의 수를 큐에 넣고
    하나 뽑고 뽑은 값을 다시 푸시

    [슈도 코드]

    N 저장
    큐 선언
    1부터 N까지 큐에 저장
    큐의 크기가 하나될 때까지
        하나 뽑고
        다시 뽑고 그 값은 푸시
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.remove();
            queue.add(queue.remove());
        }

        System.out.print(queue.remove());

        br.close();
    }
}