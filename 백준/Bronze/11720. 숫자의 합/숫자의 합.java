import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		int cnt = sc.nextInt();
		String num = sc.next();
		int answer = 0;

		for (int i = 0; i < cnt; i++) {
			answer += (int) num.charAt(i) - 48;
		}

		System.out.println(answer);
	}
}
