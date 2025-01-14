import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] flags = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long start = min / pow;
            if (min % pow != 0)
                start++;
            for (long j = start; pow * j <= max; j++) {
                flags[(int) ((j * pow) - min)] = true;
            }
        }

        int count = 0;

        for (int i = 0; i <= max - min; i++) {
            if (!flags[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}