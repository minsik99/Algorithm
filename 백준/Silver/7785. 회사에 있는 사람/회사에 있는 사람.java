import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        HashSet<String> company = new HashSet<>(); // 현재 사무실에 있는 사람 목록

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            String status = input[1];

            if (status.equals("enter")) {
                company.add(name);
            } else { // status == "leave"
                company.remove(name);
            }
        }

        // HashSet → List 변환 후 정렬
        List<String> list = new ArrayList<>(company);
        list.sort(Collections.reverseOrder());

        for (String name : list) {
            sb.append(name).append("\n");
        }

        System.out.print(sb);
    }
}