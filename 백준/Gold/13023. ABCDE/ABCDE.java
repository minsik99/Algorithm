import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 사람 수 N, 친구 관계 수 M
    출력 : 깊이가 5라면 1, 아니라면 0

    [해결 과정]

    dfs로 재귀 호출하며 깊이가 5라면 탈출

    [슈도 코드]

    N 저장, M 저장
    map 인접리스트 저장
    visited 방문 배열
    arrive 깊이 확인 플래그
    dfs 함수 실행
 */

public class Main {
    static ArrayList<Integer>[] map;
    static boolean[] visited;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new ArrayList[N];
        visited = new boolean[N];
        arrive = false;

        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (arrive) break;
        }
        if (arrive) System.out.print("1");
        else System.out.print("0");

        br.close();
    }

    private static void dfs(int current, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[current] = true;
        for (int i : map[current]) {
            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }
        visited[current] = false;
    }
}