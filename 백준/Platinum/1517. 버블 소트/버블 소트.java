import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : N 개의 정수
    출력 : 정렬 시 일어나는 swap의 횟수

    [해결 과정]

    병합 정렬을 수행하는 과정 중 일어나는 swap의 횟수

    [슈도 코드]

    N 저장
    arr 배열 선언 후 저장
    tmp 임시 재열 선언
    병합 정렬 수행
 */

public class Main {
    static int[] arr, tmp;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        tmp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        mergeSort(1, n);

        System.out.print(result);

        br.close();
    }

    private static void mergeSort(int s, int e) {
        if (e - s < 1) return;

        int m = s + (e - s) / 2;

        mergeSort(s, m);
        mergeSort(m + 1, e);

        for (int i = s; i <= e; i++) {
            tmp[i] = arr[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m + 1;

        while (index1 <= m && index2 <= e) {
            if (tmp[index1] > tmp[index2]) {
                arr[k] = tmp[index2];
                result = result + index2 - k;
                k++;
                index2++;
            } else {
                arr[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        while (index1 <= m) {
            arr[k] = tmp[index1];
            k++;
            index1++;
        }

        while (index2 <= e) {
            arr[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}