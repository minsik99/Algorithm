import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 수의 개수 N, N개의 수

    출력 : 좋은 수 출력

    [해결 과정]

    N 개의 수 중 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있으면 좋은 수다
    정렬 후 투 포인터를 사용해 순서쌍의 개수를 파악한다

    [슈도 코드]

    N 저장
    배열에 데이터 입력 후 정렬
    N 만틈 반복하며
        찾을 값, 시작, 끝 인덱스 선언
        while(시작 < 끝)
            좋은 수 찾기
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int find = arr[i];
            int start = 0;
            int end = N - 1;

            while (start < end) {
                if (start == i) {
                    start++;
                    continue;
                }
                if (end == i) {
                    end--;
                    continue;
                }
                int sum = arr[start] + arr[end];
                if (sum == find) {
                    count++;
                    break;
                } else if (sum < find) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.print(count);

        br.close();
    }
}