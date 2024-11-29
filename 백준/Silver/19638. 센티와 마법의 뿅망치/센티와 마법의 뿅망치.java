import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    [요구 사항]

    입력 : 거인 인구수, 센티의 키, 사용 횟수, 각 거인의 키

    출력 : 센티가 가장 클 수 있는지 여부, 아니라면 가장 큰 거인의 키

    [해결 과정]

    데이터 양이 많고 정렬이 필요하므로 최대힙을 통해 구한다

    [슈도 코드]

    입력값 차례대로 저장
    거인 인구수만큼 반복
        최대힙에 저장
    망치 사용 횟수만큼
        큐에서 팝하고 2로 나눈 후 푸시
    큐에서 팝한 값과 비교하여 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 거인 인구수
        int centi = Integer.parseInt(st.nextToken()); // 센티 키
        int T = Integer.parseInt(st.nextToken()); // 망치 사용 횟수
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙

        // 최대힙에 데이터 삽입
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        int usedHammer = 0; // 사용한 뿅망치 횟수

        // 뿅망치 사용
        while (T-- > 0) {
            int giant = queue.poll(); // 가장 키가 큰 거인

            if (giant < centi) {
                // 센티가 가장 큰 거인보다 커졌다면
                System.out.println("YES");
                System.out.println(usedHammer);
                return;
            }

            if (giant == 1) {
                // 키가 1이면 줄일 수 없음
                queue.add(giant);
                break;
            }

            // 뿅망치 사용: 키를 절반으로 줄이기
            queue.add(giant / 2);
            usedHammer++;
        }

        // 망치 사용 후에도 센티보다 큰 거인이 남아 있는 경우
        int tall = queue.peek(); // 현재 가장 큰 거인의 키
        if (tall < centi) {
            System.out.println("YES");
            System.out.println(usedHammer);
        } else {
            System.out.println("NO");
            System.out.println(tall);
        }

        br.close();
    }
}