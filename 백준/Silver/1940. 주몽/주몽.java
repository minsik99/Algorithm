import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 재료의 개수 N, 갑옷을 만드는데 필요한 수 M

    출력 : 갑옷을 만들 수 있는 개수

    [해결 과정]

    배열에 담고 정렬한 후 투 포인터를 통해 순서쌍의 개수를 구한다

    [슈도 코드]

    N, M 저장
    count 변수 선언
    배열에 데이터 저장 후 정렬
    시작, 끝 인덱스 선언
    while(두 인덱스가 다를 때까지)
        sum = A[start] + A[end]
        sum < M : start++
        sum > M : end--
        sum == M : count++, start++, end--
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int count = 0;
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = N - 1;

        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == M) {
                count++;
                start++;
                end--;
            } else if (sum < M) {
                start++;
            } else if (sum > M) {
                end--;
            }
        }

        System.out.print(count);

        br.close();
    }
}