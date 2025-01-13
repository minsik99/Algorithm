import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10000001];
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 2; i < Math.sqrt(arr.length); i++) {
            if (arr[i] == 0)
                continue;
            for (int j = i * i; j < arr.length; j += i) {
                arr[j] = 0;
            }
        }
        int i = n;
        while (true) {
            if (arr[i] != 0) {
                int answer = arr[i];
                if (isPalindrome(answer)) {
                    System.out.println(answer);
                    break;
                }
            }
            i++;
        }
    }

    static boolean isPalindrome(int x) {
        char[] temp = String.valueOf(x).toCharArray();
        int start = 0;
        int end = temp.length - 1;
        while (start < end) {
            if (temp[start] != temp[end])
                return false;
            start++;
            end--;
        }
        return true;
    }
}