import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 10억 이하의 수 N

    출력 : 내림차순으로 출력

    [해결 과정]

    수가 크므로 문자열로 입력받고
    선택정렬로 내림차순

    [슈도 코드]

    N 저장
    배열로 문자열 N의 자릿수 저장
    선택정렬로 내림차순
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        int[] arr = new int[line.length()];

        for (int i = 0; i < line.length(); i++) {
            arr[i] = line.charAt(i) - '0';
        }

        for (int i = 0; i < arr.length; i++) {
            int Max = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[Max]) Max = j;
            }
            if (arr[i] < arr[Max]) {
                int temp = arr[i];
                arr[i] = arr[Max];
                arr[Max] = temp;
            }
            sb.append(arr[i]);
        }

        System.out.print(sb);

        br.close();
    }
}