import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore.Entry;
import java.time.Year;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		String[] croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (i < str.length() - 1) {
				String two = str.substring(i, i + 2);
				if (new String("c= c- d- lj nj s= z=").contains(two)) {
					i++;
				} else if (i < str.length() - 2) {
					String three = str.substring(i, i + 3);
					if (three.equals("dz=")) {
						i += 2;
					}
				}
			}
			count++;
		}
		System.out.println(count);
	}
}
