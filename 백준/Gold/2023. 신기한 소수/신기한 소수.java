import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 8 이하의 N
    출력 : 신기한 소수

    [해결 과정]

    짝수는 제외하고 일의 자리부터 소수를 판별
    재귀 형태로 dfs 탐색

    [슈도 코드]

    N 저장
    DFS 실행
    DFS(2, 1);
    DFS(3, 1);
    DFS(5, 1);
    DFS(7, 1);
    DFS(숫자, 자릿수) {
        자릿수 == N 탐색 종료

        1~9까지 반복
        재귀 반복
    }
 */

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
        br.close();
    }

    private static void dfs(int number, int jarisu) {
        if (jarisu == N) {
            if (isPrime(number)) {
                System.out.println(number);
            }
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) continue;
            if (isPrime(number * 10 + i)) {
                dfs(number * 10 + i, jarisu + 1);
            }
        }
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j <= i / 2; j++) {
            if (i % j == 0)
                return false;
        }
        return true;
    }
}