import java.io.*;
import java.util.*;

public class Main {
    static int V, E, K;
    static int[] distance;
    static List<Edge>[] graph;
    static PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        distance = new int[V + 1];
        graph = new ArrayList[V + 1];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.setAll(graph, i -> new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dijkstra(int start) {
        pq.offer(new Edge(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (distance[now.vertex] < now.weight) continue;

            for (Edge next : graph[now.vertex]) {
                int newDist = distance[now.vertex] + next.weight;
                if (distance[next.vertex] > newDist) {
                    distance[next.vertex] = newDist;
                    pq.offer(new Edge(next.vertex, newDist));
                }
            }
        }
    }

    static class Edge {
        int vertex, weight;

        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}