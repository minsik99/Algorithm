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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(a, 0, n - 1, k - 1);
		bw.write(a[k - 1] + "\n");
		bw.flush();
		bw.close();
	}

	private static void quickSort(int[] a, int s, int e, int k) {
		if (s < e) {
			int pivot = partition(a, s, e);
			if (pivot == k) {
				return;
			} else if (k < pivot) {
				quickSort(a, s, pivot - 1, k);
			} else {
				quickSort(a, pivot + 1, e, k);
			}
		}
	}

	private static int partition(int[] a, int s, int e) {
		if (s + 1 == e) {
			if (a[s] > a[e]) {
				swap(a, s, e);
				return e;
			}
		}
		int m = (s + e) / 2;
		swap(a, s, m);
		int pivot = a[s];
		int i = s + 1, j = e;
		while (i <= j) {
			while (j >= s + 1 && pivot < a[j]) {
				j--;
			}
			while (i <= e && pivot > a[i]) {
				i++;
			}
			if (i <= j) {
				swap(a, i++, j--);
			}
		}
		a[s] = a[j];
		a[j] = pivot;
		return j;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}