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
	public static int[] a, tmp;
	public static long result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		a = new int[n + 1];
		tmp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
		}
		merge(1, n);
		for (int i = 1; i <= n; i++) {
			bw.write(a[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

	private static void merge(int s, int e) {
		if (e - s < 1) {
			return;
		}
		int m = s + (e - s) / 2;
		merge(s, m);
		merge(m + 1, e);
		for (int i = s; i <= e; i++) {
			tmp[i] = a[i];
		}
		int k = s;
		int index1 = s;
		int index2 = m + 1;
		while (index1 <= m && index2 <= e) {
			if (tmp[index1] > tmp[index2]) {
				a[k] = tmp[index2];
				k++;
				index2++;
			} else {
				a[k] = tmp[index1];
				k++;
				index1++;
			}
		}
		while (index1 <= m) {
			a[k] = tmp[index1];
			k++;
			index1++;
		}
		while (index2 <= e) {
			a[k] = tmp[index2];
			k++;
			index2++;
		}
	}
}