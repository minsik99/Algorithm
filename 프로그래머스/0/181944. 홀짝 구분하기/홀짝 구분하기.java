import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.print(n + check(n));
    }
    
    static String check(int n) {
        if(n % 2 == 0) {
            return " is even";
        } else {
            return " is odd";
        }
    }
}