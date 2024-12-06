import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 테스트 케이스 T, A, B의 정수

    출력 : 각 테이트 케이스에 해당하는 답

    [해결 과정]

    이진 트리를 활용
    루트 노드로 올라가며 가까운 공통 조상을 찾는다

    [슈도 코드]

    입력값 저장
    부모는 자식을 2로 나눈 값으로
    같을 때까지 나눈다
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(findParent(A, B) * 10).append("\n");
        }

        System.out.print(sb);
    }

    static int findParent(int a, int b) {
        while (a != b) {
            if (a > b) {
                a /= 2;
            } else {
                b /= 2;
            }
        }
        return a;
    }
}