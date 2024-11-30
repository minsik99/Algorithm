import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
    [요구 사항]

    입력 : 100 이하의 테스트 케이스, 0 <= n <= 30 의상의 수, 문자열

    출력 : 중복 되지 않도록 옷을 입을 수 있는 경우의 수

    [해결 과정]

    의상으로 주어지는 문자열 중 두번째 종류를 키로 맵에 저장
    value로는 종류의 수
    각 의상 종류의 수에 안입을 경우의 수까지 합쳐 n + 1에서 하나 고를 경우의 수
    모두 곱한 후 하나도 고르지 않을 경우의 수 딱 1가지를 제외한다

    [슈도 코드]

    입력값 저장
    의상 종류를 키로 의상 이름을 리스트에 담아 값으로 맵에 저장
    맵의 값들을 순회하며 경우의 수 연산
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine()); // 의상 개수
            HashMap<String, Integer> map = new HashMap<>(); // 의상 종류별 개수 저장

            // 의상 종류별로 가짓수 삽입
            for (int i = 0; i < n; i++) {
                String[] clothes = br.readLine().split(" ");
                String type = clothes[1]; // 의상 종류
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            // 경우의 수 계산
            int result = 1;
            for (int count : map.values()) {
                result *= (count + 1); // 각 종류별 (입는 경우 + 안 입는 경우)
            }

            result--; // 모든 의상을 입지 않는 경우 제외
            sb.append(result).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}