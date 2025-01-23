import java.io.*;
import java.util.*;

public class Main {
    static int[] send = {0, 0, 1, 1, 2, 2};
    static int[] receive = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited;
    static boolean[] answer;
    static int[] now;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        now = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        now[0] = Integer.parseInt(st.nextToken());
        now[1] = Integer.parseInt(st.nextToken());
        now[2] = Integer.parseInt(st.nextToken());
        visited = new boolean[201][201];
        answer = new boolean[201];

        BFS();

        for (int i = 0; i < answer.length; i++) {
            if (answer[i])
                sb.append(i).append(" ");
        }

        System.out.print(sb);
    }

    static void BFS() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;

        while (!queue.isEmpty()) {
            AB ab = queue.poll();
            int A = ab.A;
            int B = ab.B;
            int C = now[2] - A - B;

            for (int k = 0; k < 6; k++) {
                int[] next = {A, B, C};
                next[receive[k]] += next[send[k]];
                next[send[k]] = 0;

                if (next[receive[k]] > now[receive[k]]) {
                    next[send[k]] = next[receive[k]] - now[receive[k]];
                    next[receive[k]] = now[receive[k]];
                }

                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    if (next[0] == 0)
                        answer[next[2]] = true;
                }
            }
        }
    }
}

class AB {
    int A;
    int B;

    AB(int a, int b) {
        A = a;
        B = b;
    }
}