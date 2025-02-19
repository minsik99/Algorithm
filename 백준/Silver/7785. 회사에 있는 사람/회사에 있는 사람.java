import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		ArrayList<String> list = new ArrayList<>();
		HashMap<String, String> company = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			String name = input[0];
			String status = input[1];
			if (!company.containsKey(name) || status.equals("enter")) {
				company.put(name, status);
			} else {
				company.put(name, status);
			}
		}

		for (String name : company.keySet()) {
			if (company.get(name).equals("enter"))
				list.add(name);
		}

		Collections.sort(list, Collections.reverseOrder());

		for (String s : list) {
			sb.append(s).append("\n");
		}

		System.out.print(sb);
	}
}