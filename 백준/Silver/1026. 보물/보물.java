import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 배열 길이 N, 정수 배열 A, B

    출력 : 두 배열의 곱을 모두 더한 합의 최솟값

    [해결 과정]

    최소값을 구하기 위해 A 배열에서는 내림차순으로
    B 배열에서는 오름차순으로 정렬한 후 그 값을 곱한다
    B 배열을 재배열 하지 않는 조건이 있으므로 임시 배열을 통해 정렬한다

    [슈도 코드]

    입력값 저장
    A 배열은 내림차순
    B 배열은 임시 배열을 통해 오름차순 정렬
    N 만큼 반복하며
        각 배열의 곱을 합한다
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 배열 길이
        Integer[] A = new Integer[N];
        int[] B = new int[N];
        int[] temp = new int[N];
        int S = 0;

        // A 배열에 데이터 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // B 배열에 데이터 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            temp[i] = B[i];
        }

        // A 배열은 내림차순
        Arrays.sort(A, Collections.reverseOrder());

        // B 배열은 임시 배열을 통해 오름차순
        Arrays.sort(temp);

        // S의 최솟값 연산
        for (int i = 0; i < N; i++) {
            S += A[i] * temp[i];
        }

        System.out.print(S);

        br.close();
    }
}