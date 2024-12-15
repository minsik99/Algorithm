import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 문자열 길이 S, 부분문자열 길이 P

    출력 : 만들 수 있는 비밀번호의 종류

    [해결 과정]

    입력의 최대 크기가 1억이므로 O(n)의 시간 복잡도를 고려한다
    슬라이딩 윈도우로 비밀번호 탐색
    {A, C, G, T}를 배열로 개수를 체크한다
    윈도우를 한 칸씩 이동하며 만들 수 있는 배열이 비밀번호가 될지 체크

    [슈도 코드]

    문자열 길이 S, 부분문자열 길이 P 저장
    비밀번호 카운트 변수 선언
    비밀 번호 배열로 저장
    부분문자열 배열로 저장
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] dna = br.readLine().toCharArray();
        int[] minCount = new int[4];
        int[] curCount = new int[4];
        int count = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            minCount[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < P; i++) {
            addChar(dna[i], curCount);
        }

        if (isValid(curCount, minCount)) count++;

        for (int i = P; i < S; i++) {
            addChar(dna[i], curCount);
            removeChar(dna[i - P], curCount);

            if (isValid(curCount, minCount)) count++;
        }

        System.out.print(count);

        br.close();
    }

    private static boolean isValid(int[] curCount, int[] minCount) {
        for (int i = 0; i < 4; i++) {
            if (curCount[i] < minCount[i]) {
                return false;
            }
        }
        return true;
    }

    private static void removeChar(char c, int[] curCount) {
        switch (c) {
            case 'A':
                curCount[0]--;
                break;
            case 'C':
                curCount[1]--;
                break;
            case 'G':
                curCount[2]--;
                break;
            case 'T':
                curCount[3]--;
                break;
        }
    }

    private static void addChar(char c, int[] curCount) {
        switch (c) {
            case 'A':
                curCount[0]++;
                break;
            case 'C':
                curCount[1]++;
                break;
            case 'G':
                curCount[2]++;
                break;
            case 'T':
                curCount[3]++;
                break;
        }
    }
}