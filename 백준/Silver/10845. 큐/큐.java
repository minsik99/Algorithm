import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    [요구 사항]

    입력 : 명령의 개수 N
            push X: 정수 X를 큐에 넣는 연산이다.
            pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            size: 큐에 들어있는 정수의 개수를 출력한다.
            empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
            front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

    출력 : 명령어 그대로 수행 후 출력문은 출력

    [해결 과정]

    문제 요구사항 그대로 큐를 구현
    큐의 rear 값을 확인하기 위해 변수 활용

    [슈도 코드]

    명령의 개수 N 저장
    switch문으로 입력된 명령에 따라 명령 수행
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 명령의 개수
        int lastValue = 0; // back 명령 수행을 위해 마지막으로 저장된 값 저장

        Queue<Integer> queue = new ArrayDeque<>(); // 큐 선언

        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" "); // 공백으로 명령어 구분 추출

            switch (command[0]) {
                case "push":
                    lastValue = Integer.parseInt(command[1]);
                    queue.add(lastValue);
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(queue.poll()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(queue.peek()).append("\n");
                    }
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(lastValue).append("\n");
                    }
                    break;
            }
        }

        System.out.print(sb);

        br.close();
    }
}