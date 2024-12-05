import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : T 테스트케이스, 국가의 수 N, 비행기의 종류 M

    출력 : 모든 국가를 여행하기 위해 타야하는 비행기의 종류의 최소 개수

    [해결 과정]

    연결된 그래프이며 트리의 성질인 N개의 노드와 N-1의 간선의 개수를 가진다
    간선 개수만 카운트

    [슈도 코드]

    입력값 저장
    간선 개수만 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 국가 수
            int M = Integer.parseInt(st.nextToken()); // 비행 스케줄 수

            // 노드 개수 입력
            for (int i = 0; i < M; i++) {
                br.readLine();
            }

            // 간선 개수만 파악
            sb.append(N - 1).append("\n");
        }

        System.out.print(sb);
    }
}