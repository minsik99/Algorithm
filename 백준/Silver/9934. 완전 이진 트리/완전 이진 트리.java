import java.io.*;
import java.util.*;

/*
    [요구 사항]

    입력 : 정수 K, 빌딩의 번호

    출력 : i 번째 줄의 레벨이 i인 빌딩의 번호

    [해결 과정]

    완전 이진 트리를 중위 순회로 탐색

    [슈도 코드]

    입력값 저장
    중위 순회 결과를 배열로 저장
    노드를 순회하며 레벨에 따라 저장
 */

public class Main {
    static List<List<Integer>> levels; // 레벨별 결과를 저장할 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine()); // 트리의 깊이
        int n = (1 << K) - 1; // 노드 개수

        // 중위 순회
        int[] inorder = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        levels = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            levels.add(new ArrayList<>());
        }

        buildTree(inorder, 0, n - 1, 0);

        StringBuilder sb = new StringBuilder();
        for (List<Integer> level : levels) {
            for (int num : level) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void buildTree(int[] inorder, int start, int end, int level) {
        if (start > end) return; // 범위를 벗어나면 종료

        int mid = (start + end) / 2; // 현재 서브트리의 루트
        levels.get(level).add(inorder[mid]); // 해당 레벨에 노드 값 추가

        buildTree(inorder, start, mid - 1, level + 1); // 왼쪽 서브트리
        buildTree(inorder, mid + 1, end, level + 1); // 오른쪽 서브트리
    }
}