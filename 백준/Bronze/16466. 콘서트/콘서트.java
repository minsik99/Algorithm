import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

/*
    [요구 사항]

    입력 : 1,000,000 이하의 N, 이미 팔린 티켓 번호

    출력 : 이미 팔린 티켓을 제외한 티켓 중 가장 작은 번호

    [해결 과정]

    배열에 데이터를 저장한 후 오름차순으로 정렬한다
    이후 인덱스와 다른 값 탐색

    [슈도 코드]

    입력값 저장
    배열로 정렬한 후
    가장 작은 티켓 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 티켓 수
        int[] tickets = new int[N]; // 티켓 저장할 배열

        // 배열에 데이터 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tickets[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(tickets);

        // 인덱스와 배열의 값들을 비교하며 인덱스와 다르다면 남아있는 티켓
        int answer = 1;
        for (int ticket : tickets) {
            if (answer != ticket) {
                break;
            }
            answer++;
        }

        System.out.print(answer);

        br.close();
    }
}