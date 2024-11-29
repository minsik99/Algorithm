import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/*
    [요구 사항]

    입력 : 1 <= L <= 50 answkduf

    출력 : 해시 함수의 반환값

    [해결 과정]

    a:1, b:2, c:3, ... z:26, 31, 1234567891을 가지고 해시 값을 구함

    [슈도 코드]

    자연수 L 저장
    L의 길이만큼 순회
        해시값 구함
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int L = Integer.parseInt(br.readLine()); // 자연수 L
        String str = br.readLine(); // 해싱할 문자열
        long hashValue = 0;

        for (int i = 0; i < L; i++) {
            hashValue += (str.charAt(i) - 96) * Math.pow(31, i);
        }

        sb.append(hashValue % 1234567891);

        System.out.print(sb);

        br.close();
    }
}