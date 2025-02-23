import java.util.*;

class Solution {
    static int[] parent;
    static int[] rank;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        List<Edge> edges = new ArrayList<>();
        for (int[] cost : costs) {
            edges.add(new Edge(cost[0], cost[1], cost[2]));
        }
        Collections.sort(edges); 

        for (Edge edge : edges) {
            if (find(edge.nodeA) != find(edge.nodeB)) { 
                union(edge.nodeA, edge.nodeB);
                answer += edge.weight;
            }
        }

        return answer;
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }

    public int find(int target) {
        if (parent[target] != target) {
            parent[target] = find(parent[target]); 
        }
        return parent[target];
    }
}

class Edge implements Comparable<Edge> {
    int nodeA;
    int nodeB;
    int weight;

    Edge(int nodeA, int nodeB, int weight) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}