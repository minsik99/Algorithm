import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    [요구 사항]

    입력 : 테스트 T, 1,000,000이하의 정수 K, 파일 크기

    출력 : 파일을 합칠 때 필요한 최소 비용

    [해결 과정]

    파일을 합치고 난 값도 다시 연산에 활용해야 한다
    큐의 구조를 활용해서 팝하고 다시 푸시
    최소값을 구해야 하므로 우선순위 큐로 최소힙을 활용
    큐가 하나 남을 때까지 두 개씩 팝하고 다시 큐에 넣는다

    [슈도 코드]

    입력값 저장
    테스트 케이스, 파일 개수 만큼 이중 반복문을 돌며
        합 연산 결과 저장할 변수
        최소힙 선언
        데이터를 모두 큐에 삽입 후
            while (큐의 크기가 1이 될 때까지)
                차례대로 하나씩 두 개의 숫자를 팝하고
                더해서 다시 큐에 넣는다
        이후 큐에서 팝하고 이전까지 합 연산하던 변수에 더하고 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 수

        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine()); // 파일 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> queue = new PriorityQueue<>(); // 최소힙 선언
            long sum = 0; // 합 연산 저장
            // 큐에 데이터 삽입
            for (int i = 0; i < K; i++) {
                queue.add(Long.parseLong(st.nextToken()));
            }
            // 큐의 사이즈가 1이 될 때까지
            while (queue.size() > 1) {
                long first = queue.poll(); // 첫 번째로 작은 수
                long second = queue.poll(); // 두 번째로 작은 수
                sum += first + second;
                queue.add(first + second); // 이후 다시 큐에 푸시
            }
            
            sb.append(sum).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}