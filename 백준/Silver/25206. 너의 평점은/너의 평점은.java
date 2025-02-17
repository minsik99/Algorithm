import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore.Entry;
import java.time.Year;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<String, Double> score = Map.ofEntries(
		        Map.entry("A+", 4.5), Map.entry("A0", 4.0), Map.entry("B+", 3.5), Map.entry("B0", 3.0),
		        Map.entry("C+", 2.5), Map.entry("C0", 2.0), Map.entry("D+", 1.5), Map.entry("D0", 1.0),
		        Map.entry("F", 0.0));


		double sum = 0.0;
		double total = 0.0;

		for (int i = 0; i < 20; i++) {
			String[] command = br.readLine().split(" ");
			if (command[2].equals("P"))
				continue;
			double x = Double.parseDouble(command[1]);
			double y = score.get(command[2]);
			sum += x * y;
			total += x;
		}

		System.out.println(sum / total);
	}
}