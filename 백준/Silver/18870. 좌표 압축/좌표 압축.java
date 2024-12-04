import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : N, N개의 x 좌표

    출력 : x 좌표 압축한 후 공백으로 구분

    [해결 과정]

    좌표 압축 : 좌표를 정렬한 후 순위를 매김
    같은 좌표라면 순위가 같다
    맵을 통해 중복값 처리
    이후 맵에 키로 입력받았던 값, 값으로는 매겨진 순위를 저장

    [슈도 코드]

    입력값 저장
    원본 좌표와 정렬된 좌표 배열 선언
    배열을 정렬한 후
    중복 제거를 위해 맵 선언
    맵에 키로는 원본 좌표, 값으로는 매겨진 순위를 저장
    이후 맵 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 좌표 개수
        int[] arr = new int[N]; // 원본 배열
        int[] sorted = new int[N]; // 정렬된 이후 배열

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력값 저장
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sorted[i] = arr[i];
        }

        // 오름차순 정렬
        Arrays.sort(sorted);


        // 중복을 표현하기 위해 맵 선언
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0; // 순위

        // 맵에 데이터 저장
        for (int num : sorted) {
            // 입력된 적이 없던 값만 저장
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }

        for (int num : arr) {
            sb.append(map.get(num)).append(" ");
        }

        System.out.print(sb);

        br.close();
    }
}