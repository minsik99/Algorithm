import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A = new ArrayList[V + 1];
            check = new int[V + 1];
            isEven = true;

            for (int i = 1; i <= V; i++) {
                A[i] = new ArrayList<>();
            }

            Arrays.fill(check, -1); 

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                A[start].add(end);
                A[end].add(start);
            }

            for (int i = 1; i <= V; i++) {
                if (check[i] == -1) {  
                    if (!BFS(i)) {  
                        isEven = false;
                        break;
                    }
                }
            }

            sb.append(isEven ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }

    static boolean BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        check[start] = 0;  

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i : A[node]) {
                if (check[i] == -1) {  
                    check[i] = (check[node] + 1) % 2;  
                    queue.add(i);
                } else if (check[node] == check[i]) {  
                    return false;
                }
            }
        }
        return true;
    }
}