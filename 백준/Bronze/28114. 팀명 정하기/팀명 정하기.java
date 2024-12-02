import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
    [요구 사항]

    입력 : 문제 개수 P, 입학 년도 Y, 성씨 S

    출력 : 두 가지 방법으로 만든 팀명 출력

    [해결 과정]

    방법 1. 입학 년도를 오름차순으로 정렬, 문자열로 입력 받을 때 십의 자리만 추출
    방법 2. 입력받은 문자열 중 내림차순 정렬 후 성의 앞자리 추출

    [슈도 코드]

    입력값 저장
    배열로 정렬한 값 반환
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] solved = new int[3]; // 해결한 문제
        int[] years = new int[3]; // 입학 년도
        char[] names = new char[3]; // 성의 첫 글자

        HashMap<Integer, Character> map = new HashMap<>(); // 문제 개수와 이름 매핑

        // 데이터 삽입
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            solved[i] = Integer.parseInt(st.nextToken());
            years[i] = Integer.parseInt(st.nextToken()) % 100;
            names[i] = st.nextToken().charAt(0);

            map.put(solved[i], names[i]);
        }

        // 연도별로 정렬 후 출력
        quickSortAsc(years, 0, years.length - 1);

        for (int i = 0; i < years.length; i++) {
            sb.append(years[i]);
        }
        sb.append("\n");

        // 푼 문제 개수별로 정렬 후 출력
        quickSortDesc(solved, 0, solved.length - 1);

        for (int num : solved) {
            sb.append(map.get(num));
        }

        System.out.print(sb);

        br.close();
    }

    // 오름차순 퀵정렬
    public static void quickSortAsc(int[] arr, int start, int finish) {
        if (start >= finish) {
            return;
        }

        int pivot = start;
        int left = start + 1;
        int right = finish;

        while (left <= right) {
            while (left <= finish && arr[left] <= arr[pivot]) left++;
            while (right > start && arr[right] >= arr[pivot]) right--;

            int temp = arr[right];

            if (left > right) {
                arr[right] = arr[pivot];
                arr[pivot] = temp;
            } else {
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }

        quickSortAsc(arr, start, right - 1);
        quickSortAsc(arr, right + 1, finish);
    }

    // 내림차순 퀵정렬
    public static void quickSortDesc(int[] arr, int start, int finish) {
        if (start >= finish) {
            return;
        }

        int pivot = start;
        int left = start + 1;
        int right = finish;

        while (left <= right) {
            while (left <= finish && arr[left] >= arr[pivot]) left++;
            while (right > start && arr[right] <= arr[pivot]) right--;

            if (left > right) {
                int temp = arr[right];
                arr[right] = arr[pivot];
                arr[pivot] = temp;
            } else {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }

        quickSortDesc(arr, start, right - 1);
        quickSortDesc(arr, right + 1, finish);
    }
}