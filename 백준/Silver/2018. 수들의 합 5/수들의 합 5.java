import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 정수 N

    출력 : 입력된 자연수 N을 연속된 자연수의 합으로 나타내는 가지수

    [해결 과정]

    입력받는 수의 최대 범위가 1억으로 O(n)의 시간복잡도 고려
    투 포인터를 활용한다

    [슈도 코드]

    N 저장
    count 1로 초기화 (바로 N을 뽑을 경우의 수)
    총합 sum 선언
    시작 인덱스와 끝 인덱스 선언
    sum > N : sum -= start, start++
    sum < N : end++, sum += end
    sum == N : end++, sum += end, count++
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 1;
        int sum = 1;
        int start = 1;
        int end = 1;

        while (end != N) {
            if (sum > N) {
                sum -= start;
                start++;
            }
            else if (sum < N) {
                end++;
                sum += end;
            } else {
                end++;
                sum += end;
                count++;
            }
        }

        System.out.print(count);
    }
}