import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 수의 개수 N, N개의 정수

    출력 : 산술평균, 중앙값, 최빈값, 범위

    [해결 과정]

    데이터를 정렬한 후 통계를 구한다
    컬렉션의 sort로 배열 정렬한 후 계산
    최빈값은 범위가 8001인 배열로 각 숫자의 빈도수 저장
    인덱스 계산을 위해 모든 값에 4000을 더한다

    [슈도 코드]

    입력값 저장
    배열 정렬
    출력에 필요한 각 통계값 연산
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 정수 개수
        int[] numbers = new int[N];
        int sum = 0;
        int[] count = new int[8001];

        // 데이터 입력
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
            count[numbers[i] + 4000]++;
        }

        Arrays.sort(numbers);

        // 산술 평균
        int avg = Math.round((float) sum / N);
        sb.append(avg).append("\n");

        // 중앙값
        int mid = numbers[N / 2];
        sb.append(mid).append("\n");

        // 최빈값
        int most = 0;
        int maxCount = 0;
        boolean flag = false; // 중복값 여부 확인

        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                most = i - 4000;
                flag = true;
            } else if (count[i] == maxCount && flag) {
                most = i - 4000;
                flag = false;
            }
        }

        sb.append(most).append("\n");

        // 범위
        int range = numbers[N - 1] - numbers[0];
        sb.append(range).append("\n");

        System.out.println(sb);
    }
}