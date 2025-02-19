import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();

        // 집합 S에 포함된 문자열 입력 받기
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        int count = 0;

        // 검사할 문자열 입력 받으면서 바로 확인
        for (int i = 0; i < m; i++) {
            if (set.contains(br.readLine())) {
                count++;
            }
        }

        sb.append(count);
        System.out.print(sb);
    }
}