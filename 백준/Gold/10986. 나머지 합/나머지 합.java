import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 정수 N, M, N개의 수

    출력 : 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수

    [해결 과정]

    구간의 합을 구해야 하므로 합 배열 사용
    합배열을 구한 후 M으로 나눈다 -> 분배 법칙 (x + y) / z = ((x / z) + (y / z)) / z
    이미 배열의 원소가 0인 개수를 세어 정답에 더한다
    원소 값이 같은 원소 중 2개를 뽑는 모든 경우의 수까지 더한다

    [슈도 코드]

    정수 N, M 저장
    카운트 배열 선언
    합배열 선언 후 데이터 입력
    배열의 모든 요소를 M으로 모듈러 연산
    그 중 0인 원소의 개수를 카운트에 더한다
    원소의 값이 같은 원소 중 2개를 뽑는 모든 경우의 수도 더한다
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] S = new long[N];
        long[] count = new long[M];
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        S[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int remainder = (int) (S[i] % M);
            if (remainder == 0) answer++;
            count[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if (count[i] > 1) {
                answer = answer + (count[i] * (count[i] - 1) / 2);
            }
        }

        System.out.print(answer);
    }
}