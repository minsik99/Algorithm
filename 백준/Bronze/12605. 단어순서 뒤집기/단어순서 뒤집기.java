import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    [요구 사항]

    입력 : 케이스의 개수 N, 스페이스로 구분된 문자열

    출력 : 단어의 순서를 바꾸어 출력

    [해결 과정]

    스택의 동작 구조 lifo 구조를 활용

    [슈도 코드]

    케이스 개수 N 저장
    N만큼 순회하며
        스택 선언
        공백으로 구분된 단어 푸시
        StringBuilder로 스택에서 팝하며 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 케이스의 개수

        // N만큼 반복하며 스택 삽입
        for (int i = 0; i < N; i++) {
            Stack<String> stack = new Stack<>(); // 스택 선언

            String[] str = br.readLine().split(" ");

            // 스택에 푸시
            for (int j = 0; j < str.length; j++) {
                stack.push(str[j]);
            }

            sb.append("Case #" + (i + 1) + ": ");

            // 스택이 빌때까지 팝
            while (!stack.isEmpty()) {
                sb.append(stack.pop() + " ");
            }

            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}