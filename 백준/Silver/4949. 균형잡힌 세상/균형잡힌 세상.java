import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    [요구 사항]

    입력 : 100 글자 이하의 문자열
          .이면 종료

    출력 : 각 문자열의 ()와 []의 짝이 맞다면 yes, 아니면 no

    [해결 과정]

    정규표현식을 사용하여 괄호만 남긴다
    이후 스택을 활용하여 짝 검사

    [슈도 코드]

    while문으로 입력된 문자열이 .이 아니라면 반복
    정규표현식으로 ([])만 남긴다
    스택 선언
    빈 스택이거나 열린 괄호는 push
    닫힌 괄호는 짝에 맞게 pop
    스택 size가 0이라면 yes, 아니라면 no 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine(); // 입력된 문자열
            if (str.equals(".")) break; // "." 종료 조건을 만나면 탈출

            str = str.replaceAll("[^()\\[\\]]", ""); // 괄호가 아니라면 제거

            Stack<Character> stack = new Stack<>(); // 스택 선언

            // 스택이 비었거나 열린 괄호라면 push
            for (char c : str.toCharArray()) {
                if (stack.isEmpty() || c == '(' || c == '[') {
                    stack.push(c); // 열린 괄호 추가
                } else {
                    if (stack.peek() == '(' && c == ')') {
                        stack.pop();
                    } else if (stack.peek() == '[' && c == ']') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }

            if (stack.size() == 0) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }

        System.out.print(sb);

        br.close();
    }
}