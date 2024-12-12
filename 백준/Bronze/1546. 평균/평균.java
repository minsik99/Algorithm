import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 과목의 개수 N, 성적

    출력 : 평균

    [해결 과정]

    주어진 수 중 최대값을 구한다
    주어진 수의 합에서 최댓값으로 나눈 후 100을 곱하고 3으로 나눈다

    [슈도 코드]

    과목 개수 N 저장
    최댓값 변수 선언
    총합 변수 선언
    N개의 수 배열로 저장
    입력받을 때마다 최댓값 갱신
    이후 연산
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int[] scores = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            if (scores[i] > max) max = scores[i];
            sum += scores[i];
        }

        float answer = sum * 100.0f / max / N;
        sb.append(answer);

        System.out.print(sb);
    }
}