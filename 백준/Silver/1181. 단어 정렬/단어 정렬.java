import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : N, N개의 영단어

    출력 : 단어의 길이 짧은 순으로, 같다면 사전 순으로 정렬, 중복 제거

    [해결 과정]

    TreeSet으로 정렬과 중복을 해결

    [슈도 코드]

    입력값 저장
    트리셋 선언 후 데이터 삽입
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 단어 개수

        Set<String> words = new TreeSet<>((w1, w2) -> {
            // 길이가 같다면 사전순
            if (w1.length() == w2.length()) {
                return w1.compareTo(w2);
            }
            // 아니라면 길이순
            return Integer.compare(w1.length(), w2.length());
        });

        // 데이터 삽입
        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        // 출력
        for (String word : words) {
            sb.append(word).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}