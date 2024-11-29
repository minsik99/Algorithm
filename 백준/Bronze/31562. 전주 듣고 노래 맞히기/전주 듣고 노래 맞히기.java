import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/*
    [요구 사항]

    입력 : 1 <= N, M <= 1,000개 노래, 계이름

    출력 : 3개 이상 = 제목, 2개 이상 = ?, 없다면 = !

    [해결 과정]

    키로 첫 3 음을 저장한 후
    첫 세 음에 따라 출력

    [슈도 코드]

    자연수 N, M 저장
    노래제목과 음을 저장할 맵 선언
    N만큼 순회하며
        제목 길이 T를 통해 공백으로 구분된 음 추출
        맵에 저장
        조건에 따라 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 노래의 개수
        int M = Integer.parseInt(st.nextToken()); // 맞출 노래의 개수

        HashMap<String, List<String>> songs = new HashMap<>(); // 노래를 저장할 맵

        // 노래 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // 노래 제목 길이 T는 사용하지 않음
            String title = st.nextToken(); // 노래 제목
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < 3; j++) { // 첫 3음만 사용
                key.append(st.nextToken());
            }
            // 맵에 키와 제목 추가
            songs.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(title);
        }

        // 퀴즈
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                key.append(st.nextToken());
            }
            // 조건에 따라 출력
            if (!songs.containsKey(key.toString())) {
                sb.append("!\n");
            } else {
                List<String> titles = songs.get(key.toString());
                if (titles.size() == 1) {
                    sb.append(titles.get(0)).append("\n");
                } else {
                    sb.append("?\n");
                }
            }
        }

        System.out.print(sb);

        br.close();
    }
}