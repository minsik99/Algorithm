import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();
		int[] counts = new int[3];
		int[] math1 = { 1, 2, 3, 4, 5 };
		int[] math2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] math3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == math1[i % math1.length])
				counts[0]++;
			if (answers[i] == math2[i % math2.length])
				counts[1]++;
			if (answers[i] == math3[i % math3.length])
				counts[2]++;
		}

		int max = Math.max(counts[0], Math.max(counts[1], counts[2]));
		for (int i = 0; i < 3; i++) {
			if (counts[i] == max) {
				list.add(i + 1);
			}
		}

		Collections.sort(list);
		return list.stream().mapToInt(x -> x).toArray();
    }
}