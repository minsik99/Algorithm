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

class data implements Comparable<data> {
	int value;
	int index;

	public data(int value, int index) {
		super();
		this.value = value;
		this.index = index;
	}

	@Override
	public int compareTo(data o) {
		return this.value - o.value;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		data[] a = new data[n];
		for (int i = 0; i < n; i++) {
			a[i] = new data(Integer.parseInt(br.readLine()), i);
		}
		Arrays.sort(a);
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (max < a[i].index - i) {
				max = a[i].index - i;
			}
		}
		bw.write((max + 1) + "\n");
		bw.flush();
		bw.close();
	}
}