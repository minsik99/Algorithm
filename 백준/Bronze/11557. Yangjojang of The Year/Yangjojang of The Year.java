import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 수

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 학교 수
            String maxSchool = ""; // 가장 많은 술을 소비한 학교
            int maxQuantity = 0; // 가장 많은 술의 양

            // 학교 수만큼 입력 받기
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String school = st.nextToken(); // 학교 이름
                int quantity = Integer.parseInt(st.nextToken()); // 소비한 술의 양

                // 가장 많은 술을 소비한 학교 찾기
                if (quantity > maxQuantity) {
                    maxQuantity = quantity;
                    maxSchool = school;
                }
            }

            // 결과 저장
            sb.append(maxSchool).append("\n");
        }

        System.out.print(sb);
    }
}