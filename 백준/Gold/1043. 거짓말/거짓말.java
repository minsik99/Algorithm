import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static ArrayList<Integer>[] party;
    static Set<Integer> trueSet;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        trueSet = new HashSet<>();

        for (int i = 0; i < T; i++) {
            trueSet.add(Integer.parseInt(st.nextToken()));
        }

        party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
        }

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            int firstPerson = -1;

            for (int j = 0; j < partySize; j++) {
                int person = Integer.parseInt(st.nextToken());
                party[i].add(person);
                if (j == 0) {
                    firstPerson = person;
                } else {
                    union(firstPerson, person);
                }
            }
        }

        Set<Integer> trueRoots = new HashSet<>();
        for (int p : trueSet) {
            trueRoots.add(find(p));
        }

        result = 0;
        for (int i = 0; i < M; i++) {
            boolean canLie = true;
            for (int person : party[i]) {
                if (trueRoots.contains(find(person))) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) result++;
        }

        System.out.println(result);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}