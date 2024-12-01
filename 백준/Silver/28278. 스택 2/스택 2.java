import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			String[] command = br.readLine().split(" ");
			switch(command[0]) {
				case "1":
					stack.add(Integer.parseInt(command[1]));
					break;
				case "2":
					if (stack.isEmpty()) {
						sb.append("-1").append("\n");
					} else {
						sb.append(stack.pop()).append("\n");
					}
					break;
				case "3":
					sb.append(stack.size()).append("\n");
					break;
				case "4":
					if (stack.isEmpty()) {
						sb.append("1").append("\n");
					} else {
						sb.append("0").append("\n");
					}
					break;
				case "5":
					if (stack.isEmpty()) {
						sb.append("-1").append("\n");
					} else {
						sb.append(stack.peek()).append("\n");
					}
					break;
			}
		}
		System.out.print(sb);
		br.close();
	}
}