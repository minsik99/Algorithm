import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder()); 
        PriorityQueue<Integer> minusPq = new PriorityQueue<>(); 
        int one = 0; 
        int zero = 0; 

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) zero++;
            else if (number == 1) one++;
            else if (number > 1) plusPq.add(number);
            else minusPq.add(number);
        }

        int answer = 0;

        while (plusPq.size() > 1) {
            int x = plusPq.remove();
            int y = plusPq.remove();
            answer += x * y;
        }
        if (!plusPq.isEmpty()) answer += plusPq.remove();

        while (minusPq.size() > 1) {
            int x = minusPq.remove();
            int y = minusPq.remove();
            answer += x * y;
        }
        if (!minusPq.isEmpty()) {
            if (zero == 0) answer += minusPq.remove();
        }

        answer += one;
        
        System.out.print(answer);

        br.close();
    }
}