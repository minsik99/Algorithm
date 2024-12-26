import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] a;
	public static long result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		a = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
		}
		radix(a, 5);
		for (int i = 0; i < n; i++) {
			bw.write(a[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

	private static void radix(int[] a2, int size) {
		int[] output = new int[a.length];
		int jarisu = 1;
		int count = 0;
		while (count != size) {
			int[] bucket = new int[10];
			for (int i = 0; i < a.length; i++) {
				bucket[(a[i] / jarisu) % 10]++;
			}
			for (int i = 1; i < 10; i++) {
				bucket[i] += bucket[i - 1];
			}
			for (int i = a.length - 1; i >= 0; i--) {
				output[bucket[(a[i] / jarisu % 10)] - 1] = a[i];
				bucket[(a[i] / jarisu) % 10]--;
			}
			for (int i = 0; i < a.length; i++) {
				a[i] = output[i];
			}
			jarisu *= 10;
			count++;
		}
	}
}
