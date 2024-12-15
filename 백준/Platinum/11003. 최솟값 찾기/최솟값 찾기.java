import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int L = Integer.parseInt(st.nextToken()); // 윈도우 크기
        int[] arr = new int[N]; // 입력 배열
        Deque<Integer> deque = new ArrayDeque<>(); // 인덱스를 저장하는 덱

        // 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            // 덱에서 현재 인덱스보다 오래된 값 제거
            if (!deque.isEmpty() && deque.getFirst() < i - L + 1) {
                deque.removeFirst();
            }

            // 덱에서 현재 값보다 큰 값 제거
            while (!deque.isEmpty() && arr[deque.getLast()] > arr[i]) {
                deque.removeLast();
            }

            // 현재 값의 인덱스 추가
            deque.addLast(i);

            // 덱의 첫 번째 값이 최소값
            sb.append(arr[deque.getFirst()]).append(" ");
        }

        System.out.print(sb);
    }
}