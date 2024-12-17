import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 문자열 S

    출력 : S의 단어를 뒤집어서 출력

    [해결 과정]

    태그는 제외하고 나머지 단어들은 뒤집어야 한다
    <, >를 만나면 바로 출력
    나머지는 큐에 담고 출력

    [슈도 코드]

    문자배열로 S 저장
    스택 선언
    배열 길이만큼 반복
        <>를 만나면 출력
        아니라면 큐에 담고 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        String S = br.readLine();

        for (char c : S.toCharArray()) {
            if (c == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                flag = true;
                sb.append(c);
            } else if (c == '>') {
                flag = false;
                sb.append(c);
            } else if (flag) {
                sb.append(c);
            } else {
                if (c == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                } else {
                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.print(sb);

        br.close();
    }
}