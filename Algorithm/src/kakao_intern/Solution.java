package kakao_intern;

public class Solution {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 }, "left"));
	}

	public static String solution(int[] numbers, String hand) {
		int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상 하 좌 우
		int[][] map = { { 1, 2,3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 },
				{ 10, 11, 12 } };
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
				if(tmp == 0) tmp = 11;
				boolean lb = false, rb = false;

				if (map[L[0]][L[1]] == tmp)
					answer += "L";
				else if (map[R[0]][R[1]] == tmp)
					answer += "R";
				else {
					for (int j = 0; j < dir.length; j++) {
						int lr = L[0] + dir[j][0];
						int lc = L[1] + dir[j][1];
						if (lr >= 0 && lc >= 0 && lr < 4 && lc < 3 && map[lr][lc] == tmp) {
							L[0] = (tmp - 1) / 3;
							L[1] = (tmp - 1) % 3;
							lb = true;
						}
						int rr = R[0] + dir[j][0];
						int rc = R[1] + dir[j][1];
						if (rr >= 0 && rc >= 0 && rr < 4 && rc < 3 && map[rr][rc] == tmp) {
							R[0] = (tmp - 1) / 3;
							R[1] = (tmp - 1) % 3;
							rb = true;
						}

					}
					if (lb && rb) {
						if (hand.equals("left"))
							answer += "L";
						else
							answer += "R";
					} else if (lb)
						answer += "L";
					else if (rb)
						answer += "R";
				}
			}
		}
		return answer;
	}
}
