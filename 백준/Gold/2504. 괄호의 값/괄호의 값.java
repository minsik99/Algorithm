import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    [요구 사항]

    입력 : 1 이상 30 이하의 길이를 가진 문자열
            () : 2
            [] : 3
            ()로 쌓여 있으면 * 2
            []로 쌓여 있으면 * 3
            연결 된 괄호는 +

    출력 : 괄호열의 값을 나타내는 정수, 짝이 맞지 않으면 0 출력

    [해결 과정]

    짝을 맞춰야 하므로 스택을 사용
    총합을 저장할 변수 하나
    괄호 종류에 따라 곱해줄 변수 하나
    총 두 개의 변수로 괄호 곱셈 계산
    짝이 맞았을 때
        닫는 괄호 바로 앞 인덱스에 열린 괄호였다면 더하기
        아니라면 곱한 값 더하기

    [슈도 코드]
    문자열 저장
    합을 저장할 변수 sum
    곱셈을 계산할 변수 multiplier
    스택이 비었거나 열린 괄호라면 push
    닫힌 괄호라면
        바로 직전에 열린 괄호가 있다면
        sum += multiplier
        아니라면
        pop
        multiply 복구
    스택의 size가 0이라면 sum, 아니라면 0 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine(); // 입력된 괄호열
        Stack<Character> stack = new Stack<>(); // 스택 선언
        int sum = 0; // 총합
        int multiplier = 1; // 중복된 괄호에 따라 곱해줄 변수

        // 괄호열 길이만큼 순회
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i); // 괄호 하나 추출

            // '('이라면 푸시하고 곱 변수 * 2
            if (c == '(') {
                stack.push(c);
                multiplier *= 2;
            }

            // '['이라면 푸시하고 곱 변수 * 3
            else if (c == '[') {
                stack.push(c);
                multiplier *= 3;
            }

            // ')'이라면
            else if (c == ')') {
                // 스택이 비었거나 짝이 안 맞다면 탈출
                if (stack.isEmpty() || stack.peek() != '(') {
                    sum = 0;
                    break;
                }

                // 직전 괄호가 '('이라면 바로 더하기
                if (str.charAt(i - 1) == '(') {
                    sum += multiplier;
                }
                stack.pop(); // 짝 맞추기
                multiplier /= 2; // 중복 괄호로 곱한 값 복구
            }

            // ']'이라면
            else if (c == ']') {
                // 스택이 비었거나 짝이 안 맞다면 탈출
                if (stack.isEmpty() || stack.peek() != '[') {
                    sum = 0;
                    break;
                }

                // 직전 괄호가 '['이라면 바로 더하기
                if (str.charAt(i - 1) == '[') {
                    sum += multiplier;
                }
                stack.pop(); // 짝 맞추기
                multiplier /= 3; // 중복 괄호로 곱한 값 복구
            }
        }

        // 스택이 비어 있지 않다면 짝이 맞지 않는 괄호열임
        if (!stack.isEmpty()) {
            sum = 0;
        }

        System.out.print(sum);

        br.close();
    }
}