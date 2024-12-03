import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

/*
    [요구 사항]

    입력 : 100,000이하의 정수 n, 1 a는 번호 a인 학생이 줄을 서고, 2는 학생 한 명이 식사를 한다

    출력 : 학생 수가 최대가 되었던 순간의 학생 수와 맨 뒤에 대기 중인 학생의 번호

    [해결 과정]

    먼저 오면 먼저 식사를 하므로 큐를 활용한다
    최대가 된 순간을 저장할 변수와 그 때 학생의 번호를 저장할 변수를
    초기화하며 출력

    [슈도 코드]

    입력값 저장
    데이터를 저장할 큐 선언
    최대 대기줄, 그때의 최소 번호 변수 선언
    n 만큼 반복하며
        큐에 데이터 삽입
        1은 푸시
        2는 팝
        만약 큐의 사이즈가 최대를 갱신하면 초기화
            이 때 번호도 초기화
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 테스트 수
        Queue<Integer> queue = new ArrayDeque<>(); // 데이터 저장할 큐 선언
        int maxLength = 0; // 줄의 최대 길이
        int minStudent = Integer.MAX_VALUE; // 학생의 최소 번호

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" "); // 명령어 추출

            // 명령어에 따라
            switch (command[0]) {
                case "1":
                    // 데이터 푸시
                    int student = Integer.parseInt(command[1]);
                    queue.add(student);

                    // 만약 최대 길이가 갱신되면 최대 길이, 학생번호 다 초기화
                    if (queue.size() > maxLength) {
                        maxLength = queue.size();
                        minStudent = student;
                    }
                    // 또는 대기 줄이 길이가 같다면 학생 번호 초기화
                    else if (queue.size() == maxLength) {
                        if (minStudent > student) {
                            minStudent = student;
                        }
                    }
                    break;
                case "2":
                    // 데이터 팝
                    queue.poll();
                    break;
            }
        }

        System.out.print(maxLength + " " + minStudent);

        br.close();
    }
}