import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : N개의 정수
    출력 : 찾으려는 수가 있다면 1, 아니면 0

    [해결 과정]

    이진 탐색 적용

    [슈도 코드]

    N 저장, M 저장
    arr 배열 저장 후 정렬
    이진 탐색
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 정렬
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (binarySearch(arr, target)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        br.close();
        System.out.print(sb);
    }

    // 이진 탐색 함수
    private static boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}