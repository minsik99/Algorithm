import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    [요구 사항]

    입력 : 자연수 1,000,000자리 이하의 수

    출력 : 문제 변환의 과정과 3의 배수 여부

    [해결 과정]

    입력받는 수의 단위가 너무 크다 -> 문자열로 처리
    문자열 -> 숫자 변환
    한 자리 수가 될 때까지 == 문자열의 길이가 1일 때까지

    [슈도 코드]
    입력받는 자연수 문자열로 저장
    변환의 과정 카운트 변수 선언
    과정 중 자릿수들의 합을 저장할 변수 선언
    while 문 (조건 : 문자열의 길이가 1일 때까지)
        카운트 증가
        자릿수들끼리 합 연산
        문자열 초기화
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String X = br.readLine(); // 자연수
        int count = 0; // 변환 과정 카운트

        while (X.length() > 1) {
            int sum = 0; // 자릿수들의 합
            count++;
            for (char c : X.toCharArray()) {
                sum += c - '0'; // char형에서 형변환
            }
            X = String.valueOf(sum);
        }

        sb.append(count).append("\n");

        if (Integer.parseInt(X) % 3 == 0) {
            sb.append("YES");
        } else {
            sb.append("NO");
        }

        System.out.println(sb);

        br.close();
    }
}