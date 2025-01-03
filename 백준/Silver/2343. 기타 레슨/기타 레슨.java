import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 강의의 수 N, M
    출력 : 블루레이의 최소 크기

    [해결 과정]

    이진 탐색으로 해결

    [슈도 코드]

    N 저장, M 저장
    arr 배열 저장
    start, end 인덱스
    while(start <= end)
        sum + 현재 시간 > 중간 인덱스
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int start = 0;
        int end = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (start < arr[i])
                start = arr[i];
            end += arr[i];
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if (sum != 0)
                count++;
            if (count > M)
                start = mid + 1;
            else
                end = mid - 1;
        }

        System.out.print(start);
        br.close();
    }
}