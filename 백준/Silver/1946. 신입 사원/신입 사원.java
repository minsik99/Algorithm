import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 테스트 케이스 T, 지원자 N

    출력 : 각 테스트 케이스에 대해 선발할 수 있는 신입사원의 최대 인원 수

    [해결 과정]

    서류와 면접 점수가 높을수록 합격
    동석차는 없으므로 서류 점수를 통해 오름차순으로 정렬
    이후 면접 점수 또한 작다면 탈락 아니면 합격 처리

    [슈도 코드]

    입력값 저장
    이중으로 반복문을 돌며
        서류 점수로 오름차순 정렬
        합격자 수 선언
        면접 최솟값 선언
        면접 점수의 최솟값이 갱신된다면 합격 처리 후 초기화
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 지원자
            int[][] arr = new int[N][2]; // 점수 저장할 2차원 배열

            // 입력값 저장
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken()); // 서류 점수
                arr[i][1] = Integer.parseInt(st.nextToken()); // 면접 점수
            }

            // 서류 점수로 오름차순 정렬, 작을수록 높은 점수
            Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

            int count = 0; // 합격자
            int minScore = Integer.MAX_VALUE; // 면접 점수 최소값

            // 최소 면접 점수가 합격자 수 증가 후 초기화
            for (int[] ar : arr) {
                if (ar[1] < minScore) {
                    count++;
                    minScore = ar[1];
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}