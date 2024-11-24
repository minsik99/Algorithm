import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if (isGroupWord(word)) {
                count++;
            }
        }
        System.out.println(count);

        br.close();
    }

    static boolean isGroupWord(String word) {
        HashSet<Character> set = new HashSet<Character>();
        char lastChar = '\0';

        for (char ch : word.toCharArray()) {
            if (ch != lastChar) {
                if (set.contains(ch)) {
                    return false;
                }
                set.add(ch);
                lastChar = ch;
            }
        }
        return true;
    }
}
