import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<Integer, String> pokemonNum = new HashMap<Integer, String>();
		HashMap<String, Integer> pokemonName = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			pokemonNum.put(i + 1, name);
			pokemonName.put(name, i + 1);
		}

		for (int i = 0; i < M; i++) {
			String quiz = br.readLine();
			String type = quiz.getClass().toString().substring(16);

			if (Character.isDigit(quiz.charAt(0))) {
				sb.append(pokemonNum.get(Integer.parseInt(quiz))).append("\n");
			} else {
				sb.append(pokemonName.get(quiz)).append("\n");
			}
		}

		System.out.print(sb);
	}
}