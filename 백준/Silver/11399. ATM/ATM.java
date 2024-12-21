import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : N, N명의 시간

    출력 : 최솟값

    [해결 과정]

    데이터 정렬 후 모든 데이터를 더한다

    [슈도 코드]

    N 저장
    N개의 데이터 오름차순으로 정렬
    sum 변수 선언 후
    합배열의 모든 데이터 합 연산
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sumArr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = 0;
        sumArr[0] = arr[0];
        for (int i = 1; i < N; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }

        for (int i = 0; i < N; i++) {
            sum += sumArr[i];
        }

        System.out.print(sum);

        br.close();
    }
}