import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 나무의 수 N, 나무의 길이 M

    출력 : 절단기 높이의 최대값

    [해결 과정]

    이분 탐색을 활용
    가장 높은 값을 출력

    [슈도 코드]

    입력값 저장
    최대값을 저장할 변수 ㅅ언
    반복문을 통해 이분 탐색
        나무 길이에 따라 탐색 범위를 나눈다
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 나무의 수
        int m = Integer.parseInt(st.nextToken()); // 필요한 나무 길이

        int[] trees = new int[n];
        int maxHeight = 0;

        // 입력값 저장하며 최댓값 갱신
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, trees[i]);
        }

        int start = 0;
        int end = maxHeight;
        int answer = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            long sum = 0;

            // 나무 높이 총합 연산
            for (int tree : trees) {
                if (tree > mid) {
                    sum += tree - mid;
                }
            }

            if (sum >= m) {
                // 더 높게 탐색
                answer = mid;
                start = mid + 1;
            } else {
                // 높이를 낮춰 탐색
                end = mid - 1;
            }
        }

        System.out.print(answer);
    }
}