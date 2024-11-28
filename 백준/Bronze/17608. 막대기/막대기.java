import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    [요구 사항]

    입력 : 막대기의 개수 2 <= N <= 100,000, 막대기의 높이 1 <= h <= 100,000

    출력 : 오른쪽에서 보이는 막대기의 개수

    [해결 과정]

    오른쪽에서 바라본다는 건 마지막으로 삽입된 요소를 확인한다는 의미 -> 스택의 동작구조
    스택에서 하나씩 팝을 하면서 최댓값을 갱신한다면 카운트 증가

    [슈도 코드]

    막대기 개수 N 저장
    보이는 막대기의 개수 카운트 변수 선언
    막대기의 최대 높이를 저장할 변수 선언
    막대기를 저장할 스택 선언
    N만큼 순회하며
    스택에 삽입
    이후 스택에서 하나씩 팝하면서
    최대 높이가 갱신되면 카운트 증가
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 막대기의 개수
        int count = 0; // 보이는 막대기의 개수
        int maxHeight = 0; // 막대기들의 최대 높이
        Stack<Integer> stack = new Stack<>(); // 막대기들을 저장할 스택

        // N만큼 순회하며 스택에 삽입
        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        // 스택이 빌 때까지 팝하며 최대 높이 갱신
        while (!stack.isEmpty()) {
            if (stack.peek() > maxHeight) {
                maxHeight = stack.peek();
                count++;
            }
            stack.pop();
        }

        System.out.print(count);

        br.close();
    }
}