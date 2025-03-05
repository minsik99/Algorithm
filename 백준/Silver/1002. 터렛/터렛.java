import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            
            int result = findContactPoints(x1, y1, r1, x2, y2, r2);
            sb.append(result).append("\n");
        }
        
        System.out.print(sb);
    }

    public static int findContactPoints(int x1, int y1, int r1, int x2, int y2, int r2) {
        int dSquared = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1); // 거리 제곱 계산 (루트 연산 피하기)
        int sumR = (r1 + r2) * (r1 + r2); // (r1 + r2)의 제곱
        int diffR = (r1 - r2) * (r1 - r2); // (r1 - r2)의 제곱
        
        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return -1; // 두 원이 완전히 일치
        } else if (dSquared > sumR) {
            return 0; // 원이 서로 떨어져 있음
        } else if (dSquared < diffR) {
            return 0; // 한 원이 다른 원 안에 포함됨
        } else if (dSquared == sumR) {
            return 1; // 외접
        } else if (dSquared == diffR) {
            return 1; // 내접
        } else {
            return 2; // 두 점에서 만남
        }
    }
}