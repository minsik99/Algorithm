import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 수의 개수 N, 합을 구해야 하는 횟수 M

    출력 : M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합

    [해결 과정]

    구간합을 활용하여 시간복잡도를 줄인다

    [슈도 코드]

    수의 개수 N 저장
    횟수 M 저장
    합 배열 선언 후 연산
    M 만큼 반복
        합 배열 연산
        i, j 저장
        합배열[j] - 합배열[i-1]
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] array = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            array[i] = array[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            sb.append(array[j] - array[i - 1]).append("\n");
        }

        System.out.print(sb);
    }
}