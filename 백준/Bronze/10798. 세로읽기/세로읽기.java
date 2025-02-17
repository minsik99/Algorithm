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
        StringBuilder sb = new StringBuilder();

        String[] input = new String[5];
        int maxLen = 0;

        for (int i = 0; i < 5; i++) {
            input[i] = br.readLine();
            maxLen = Math.max(maxLen, input[i].length());
        }

        char[][] arr = new char[5][maxLen];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                arr[i][j] = input[i].charAt(j);
            }
        }

        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] != '\0') {
                    sb.append(arr[j][i]);
                }
            }
        }

        System.out.println(sb);
    }
}