import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 요구 사항
 * 입력 : 버튼을 누른 횟수 1 <= N <= 1,000,000, 1~3까지 정수와 문자
 * 출력 : 규칙에 따라 완성된 문자열
 *
 * 문제 풀이
 * 입력받는 정수가 크기에 O(N)의 시간복잡도를 고려
 * 맨 앞, 맨 뒤에 삽입이 일어나고 가장 나중에 추가된 요소를 제거한다 -> deque로 관리
 * 가장 최근에 추가된 블록을 제거하기 위해 stack 사용
 * StringBuilder를 통해 문자열이 비었다면 0, 아니라면 완성된 문자열 반환
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 입력받은 정수
        Deque<String> blocks = new LinkedList<>(); // 덱으로 관리
        Stack<Boolean> stack = new Stack<>(); // 최근의 블록을 제거하기 위해 사용

        // 덱에 추가
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken()); // 입력받는 명령어
            String alphabet = "";

            // 3이라면 받아올 문자가 없음
            if (command != 3) {
                alphabet = st.nextToken();
            }

            switch (command) {
                case 1:
                    blocks.addLast(alphabet);
                    stack.add(true);
                    break;
                case 2:
                    blocks.addFirst(alphabet);
                    stack.add(false);
                    break;
                case 3:
                    if (!blocks.isEmpty()) {
                        if (stack.pop()) {
                            blocks.removeLast();
                        } else {
                            blocks.removeFirst();
                        }
                    }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : blocks) {
            sb.append(s);
        }

        System.out.print(sb.length() == 0 ? "0" : sb);

        br.close();
    }
}