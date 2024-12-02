import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    [요구 사항]

    입력 : 100이하의 테스트 개수, 1,000,000 이하의 N, M

    출력 : 세준이 이기면 S, 세비가 이기면 B, 둘 다 아니라면 C

    [해결 과정]

    가장 강한 병사만 비교한다

    [슈도 코드]

    입력값 저장
    두 배열을 선언하고 정렬시킨다
    조건에 따라 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 수

        for (int t = 0; t < T; t++) {
            br.readLine();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 세준 부대 병사 수
            int M = Integer.parseInt(st.nextToken()); // 세비 부대 병사 수

            int[] sejun = new int[N];
            int[] sebi = new int[M];

            // 세준
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                sejun[i] = Integer.parseInt(st.nextToken());
            }

            // 세비
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                sebi[i] = Integer.parseInt(st.nextToken());
            }

            // 정렬
            Arrays.sort(sejun);
            Arrays.sort(sebi);

            // 가장 강한 병사를 비교
            if (sejun[N - 1] >= sebi[M - 1]) {
                sb.append("S\n"); // 세준 부대 승리
            } else {
                sb.append("B\n"); // 세비 부대 승리
            }
        }

        System.out.print(sb);
    }
}