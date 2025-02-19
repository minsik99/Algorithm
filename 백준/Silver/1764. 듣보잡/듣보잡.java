import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashSet<String> names = new HashSet<>();

		for (int i = 0; i < n; i++) {
			names.add(br.readLine());
		}

		int count = 0;
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			String name = br.readLine();
			if (names.contains(name)) {
				count++;
				list.add(name);
			}
		}

		Collections.sort(list);

		sb.append(count).append("\n");
		for (String s : list)
			sb.append(s).append("\n");

		System.out.print(sb);
	}
}