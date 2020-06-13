package kakao_intern;

import java.util.HashMap;

public class Solution1_2 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 }, "left"));
	}

	public static String solution(int[] numbers, String hand) {
		HashMap<Integer, int[]> map = new HashMap<>();
		map.put(1, new int[] { 0, 0 });
		map.put(2, new int[] { 0, 1 });
		map.put(3, new int[] { 0, 2 });
		map.put(4, new int[] { 1, 0 });
		map.put(5, new int[] { 1, 1 });
		map.put(6, new int[] { 1, 2 });
		map.put(7, new int[] { 2, 0 });
		map.put(8, new int[] { 2, 1 });
		map.put(9, new int[] { 2, 2 });
		map.put(0, new int[] { 3, 1 });
		int[] L = { 3, 0 };
		int[] R = { 3, 2 };
		String answer = "";
		for (int i = 0; i < numbers.length; i++) {
			int tmp = numbers[i];
			if (tmp == 1 || tmp == 4 || tmp == 7) {
				L[0] = (tmp - 1) / 3;
				L[1] = (tmp - 1) % 3;
				answer += "L";
			} else if (tmp == 3 || tmp == 6 || tmp == 9) {
				R[0] = (tmp - 1) / 3;
				R[1] = (tmp - 1) % 3;
				answer += "R";
			} else {
				int cur[] = map.get(tmp);
				if (tmp == 0)
					tmp = 11;
				boolean lb = false, rb = false;
				if (cur[0] == L[0] && cur[1] == L[1])
					answer += "L";
				else if (cur[0] == R[0] && cur[1] == R[1])
					answer += "R";
				else {
					int l_dis = Integer.MAX_VALUE;
					int r_dis = Integer.MAX_VALUE;
					if (L[0] == cur[0]) {
						l_dis = Math.abs(L[1] - cur[1]);
						lb = true;
					} else if (L[1] == cur[1]) {
						l_dis = Math.abs(L[0] - cur[0]);
						lb = true;
					} else {
						l_dis = Math.abs(L[0] - cur[0]) + Math.abs(L[1] - cur[1]);
						lb = true;
					}
					if (R[0] == cur[0]) {
						r_dis = Math.abs(R[1] - cur[1]);
						rb = true;
					} else if (R[1] == cur[1]) {
						r_dis = Math.abs(R[0] - cur[0]);
						rb = true;
					} else {
						r_dis = Math.abs(R[0] - cur[0]) + Math.abs(R[1] - cur[1]);
						rb = true;
					}

					if (lb && rb) {
						if (l_dis == r_dis) {
							if (hand.equals("left")) {
								answer += "L";
								L[0] = (tmp - 1) / 3;
								L[1] = (tmp - 1) % 3;
							} else {
								answer += "R";
								R[0] = (tmp - 1) / 3;
								R[1] = (tmp - 1) % 3;
							}
						} else if (l_dis < r_dis) {
							answer += "L";
							L[0] = (tmp - 1) / 3;
							L[1] = (tmp - 1) % 3;
						} else {
							answer += "R";
							R[0] = (tmp - 1) / 3;
							R[1] = (tmp - 1) % 3;
						}
					} else if (lb) {
						answer += "L";
						L[0] = (tmp - 1) / 3;
						L[1] = (tmp - 1) % 3;
					} else if (rb) {
						answer += "R";
						R[0] = (tmp - 1) / 3;
						R[1] = (tmp - 1) % 3;
					}
				}
			}
		}
		return answer;
	}
}
