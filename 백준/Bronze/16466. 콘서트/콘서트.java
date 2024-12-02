import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    [요구 사항]
    입력 : 1,000,000 이하의 N, 이미 팔린 티켓 번호
    출력 : 이미 팔린 티켓을 제외한 티켓 중 가장 작은 번호

    [해결 과정]
    배열에 데이터를 저장한 후 오름차순으로 정렬
    정렬된 배열을 순회하며 빈 티켓 번호 탐색
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 티켓 수
        int[] tickets = new int[N]; // 티켓 저장할 배열

        // 배열에 데이터 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tickets[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬 (Arrays.sort 사용)
        Arrays.sort(tickets);

        // 가장 작은 빈 티켓 번호 찾기
        int answer = 1;
        for (int ticket : tickets) {
            if (answer != ticket) {
                break; // 빈 번호 발견
            }
            answer++;
        }

        // 결과 출력
        System.out.println(answer);
    }
}
