import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String[] sub = input.split("-");

        int answer = 0;

        for (int i = 0; i < sub.length; i++) {
            int sum = 0;

            String[] add = sub[i].split("\\+");

            for (String num : add) {
                sum += Integer.parseInt(num);
            }

            if (i == 0)
                answer += sum;
            else
                answer -= sum;
        }

        System.out.print(answer);

        br.close();
    }
}