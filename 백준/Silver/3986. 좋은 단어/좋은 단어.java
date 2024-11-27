import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    [요구 사항]

    입력 : 단어의 수 1 <= N <= 100
          A와 B로만 이루어진 단어
          좋은 단어 : 데칼코마니 처럼 서로 다른 위치에 같은 알파벳이라면 조건 충족

    출력 : 좋은 단어의 개수

    [해결 과정]

    짝을 찾아야 하므로 일단 단어의 길이는 짝수이어야 한다
    짝 맞추기 이므로 스택을 활용
    스택이 비었다면 일단 값 추가
    스택의 top이 추가할 값이 같다면 pop
    아니라면 push
    스택 size가 0이라면 좋은 단어

    [슈도 코드]

    단어의 수 N 저장
    카운트 수 선언
    for문으로 N만큼 순회하며,
    스택 선언
    길이가 홀수라면 continue
    짝수라면
        빈 스택이라면 push
        top이 추가할 값과 같다면 pop
        아니라면 push
    스택 size가 0이면 카운트 증가
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 단어의 수
        int count = 0; // 좋은 단어의 개수

        // N만큼 반복
        for (int i = 0; i < N; i++) {
            String word = br.readLine(); // 입력된 단어

            // 단어 길이가 홀수라면 고려할 필요 없음
            if (word.length() % 2 != 0) {
                continue;
            }

            Stack<Character> stack = new Stack<>(); // 스택 선언

            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j); // 인덱스에 따른 문자 추출

                // 스택이 비었거나 top이 추가할 문자와 다르다면 push
                if (stack.isEmpty() || ch != stack.peek()) {
                    stack.push(ch);
                } else {
                    stack.pop(); // 아니면 pop
                }
            }

            if (stack.size() == 0) count++;
        }

        System.out.print(count);

        br.close();
    }
}