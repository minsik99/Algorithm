import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 뒤집지 않고 정렬하는 경우
        int costWithoutReverse = countSwaps(arr);

        // 배열을 뒤집고 다시 정렬하는 경우
        reverse(arr);
        int costWithReverse = countSwaps(arr) + 1; // 뒤집는 비용 추가

        // 최소 비용 출력
        System.out.println(Math.min(costWithoutReverse, costWithReverse));
    }

    // 배열 뒤집기
    private static void reverse(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }

    // 버블 정렬로 교환 횟수 계산
    private static int countSwaps(int[] arr) {
        int n = arr.length;
        int swaps = 0;
        int[] temp = Arrays.copyOf(arr, n);

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (temp[j] > temp[j + 1]) {
                    // 교환
                    int t = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = t;
                    swaps++;
                }
            }
        }
        return swaps;
    }
}