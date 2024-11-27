import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/*
    [요구 사항]

    입력 : 명령의 수 1 <= N <= 10,000

          8가지의 명령
          push_front X: 정수 X를 덱의 앞에 넣는다.
          push_back X: 정수 X를 덱의 뒤에 넣는다.
          pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
          pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
          size: 덱에 들어있는 정수의 개수를 출력한다.
          empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
          front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
          back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.

    출력 : 출력하라는 명령이 주어질 때마다, 한 줄에 하나씩 출력

    [해결 과정]

    횟수가 만 개 이상이므로 단위가 크진 않지만 시간 제한이 0.5초 -> 배열을 고려하기 힘듦
    문제에서 이미 덱을 구현한다 했으므로 덱으로 관리

    [슈도 코드]

    명령의 수 N 저장
    덱 선언
    for문으로 N만큼 순회하며,
    switch문으로 조건에 따라 명령어 수행
    출력 명령어라면 StringBuilder로 생성
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 명령의 수

        Deque<Integer> deque = new ArrayDeque<>(); // 덱 선언

        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" "); // 명령어 추출

            // 조건에 따라 명령어 수행
            switch (command[0]) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(command[1]));
                    break;

                case "push_back":
                    deque.addLast(Integer.parseInt(command[1]));
                    break;

                case "pop_front":
                    sb.append(deque.isEmpty() ? "-1" : deque.removeFirst()).append("\n");
                    break;

                case "pop_back":
                    sb.append(deque.isEmpty() ? "-1" : deque.removeLast()).append("\n");
                    break;

                case "size":
                    sb.append(deque.size()).append("\n");
                    break;

                case "empty":
                    sb.append(deque.isEmpty() ? "1" : "0").append("\n");
                    break;

                case "front":
                    sb.append(deque.isEmpty() ? "-1" : deque.peekFirst()).append("\n");
                    break;

                case "back":
                    sb.append(deque.isEmpty() ? "-1" : deque.peekLast()).append("\n");
                    break;
            }
        }

        System.out.print(sb);

        br.close();
    }
}