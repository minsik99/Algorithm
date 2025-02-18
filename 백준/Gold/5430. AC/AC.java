import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String commands = br.readLine();
            int N = Integer.parseInt(br.readLine());

            ArrayDeque<Integer> deque = new ArrayDeque<>();

            String numbers = br.readLine();
            if (N > 0) {
                numbers = numbers.substring(1, numbers.length() - 1); 
                String[] numArray = numbers.split(",");
                for (String num : numArray) {
                    deque.add(Integer.parseInt(num.trim()));
                }
            }

            boolean isFront = true;
            boolean isError = false;

            for (char command : commands.toCharArray()) {
                if (command == 'R') {
                    isFront = !isFront;
                } else {
                    if (deque.isEmpty()) {
                        sb.append("error\n");
                        isError = true;
                        break;
                    } else {
                        if (isFront) {
                            deque.removeFirst();
                        } else {
                            deque.removeLast();
                        }
                    }
                }
            }

            if (!isError) {
                sb.append(formatDeque(deque, isFront));
            }
        }

        System.out.print(sb);
    }

    private static String formatDeque(ArrayDeque<Integer> deque, boolean isFront) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!deque.isEmpty()) {
            if (isFront) {
                sb.append(deque.removeFirst());
            } else {
                sb.append(deque.removeLast());
            }
            if (!deque.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("]\n");
        return sb.toString();
    }
}