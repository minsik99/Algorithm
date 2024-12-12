import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 표의 크기 N, 합 구할 횟수 M, 좌표 2개

    출력 : 두 좌표까지의 합

    [해결 과정]

    구간 합을 2차원으로 구현
    S[i][j] = S[i][j-1] + S[i-1][j] - S[i-1][j-1] + A[i][j]

    [슈도 코드]

    표의 크기 N 저장
    횟수 M 저장
    구간 합 2차원 배열 선언
    N 이중 반복문을 통해
        데이터 입력
    M 만큼 반복하며
        구간합 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] S = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                S[i][j] = S[i][j - 1] + S[i - 1][j] - S[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(S[x2][y2] - S[x1 - 1][y2] - S[x2][y1 - 1] + S[x1 - 1][y1 - 1]).append("\n");
        }

        System.out.print(sb);
    }
}