import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
    [요구 사항]

    입력 : 2 <= N <= 100개의 단어

    출력 : 뒤집었을 때 같은 단어의 길이 가운데 문자

    [해결 과정]

    단어를 뒤집어 가며 확인

    [슈도 코드]

    자연수 N
    단어를 저장할 배열 선언
    N만큼 순회하며
        배열에 단어 저장
        뒤집은 값이 있다면 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 단어 개수
        String[] words = new String[N]; // 단어 저장할 배열

        // 단어 배열에 저장
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        // 뒤집어서 같은 단어 찾기
        for (int i = 0; i < N; i++) {
            StringBuilder reversed = new StringBuilder(words[i]).reverse();
            for (int j = 0; j < N; j++) {
                if (words[j].equals(reversed.toString())) {
                    int len = words[i].length();
                    System.out.println(len + " " + words[i].charAt(len / 2));
                    return;
                }
            }
        }
    }
}