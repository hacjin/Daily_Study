package subset_0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_5432_쇠막대기자르기_이학진 {
	static int T;
	static int res, flag, pipe = 0, size;
	static int lazer[];
	static char[] sb;
	static boolean chk = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			res = 0;
//			String st = br.readLine();
			String st="";
			for (int j = 0; j < 12152; j++) {
				st += '(';
			}
			sb = st.toCharArray();
			size = sb.length;
//			sb = new char[size];
//			for (int j = 0; j < size; j++) {		// String to char 배열은 toCharArray로 가능하다
//				sb[j]=st.charAt(j);
//			}
			lazer = new int[size];
			subset(0);
			/*for (int j = 0; j < size; j++) {
				if (sb[j] == '(') {
					flag++;
				}
				if (sb[j] == ')') {
					if (j <= 0) {
						return;
					} else {
						if (sb[j - 1] != '(') {
							if (flag > 0) {
								pipe++;
								chk = true;
							}
						} else {
							flag--;
							if (flag > 0) {
								lazer[flag]++;
							}
						}
					}
				}
				if (chk) {
					res = res + pipe * lazer[flag] + 1;
					pipe--;
					chk = false;
					if (flag > 0) {
						lazer[flag - 1] += lazer[flag];
					}
					lazer[flag] = 0;
					flag--;
				}
			}*/
			System.out.println("#" + i + " " + res);
		}
	}

	public static void subset(int index) {		// 재귀사용시 런타임 에러 why?
		if (index == size) {
			return;
		}
		if (sb[index] == '(') {
			flag++;
		}
		if (sb[index] == ')') {
			if (index <= 0) {
				return;
			} else {
				if (sb[index - 1] != '(') {
					if (flag > 0) {
						pipe++;
						chk = true;
					}
				} else {
					flag--;
					if (flag > 0) {
						lazer[flag]++;
					}
				}
			}
		}
		if (chk) {
			res = res + pipe * lazer[flag] + 1;
			pipe--;
			chk = false;
			if (flag > 0) {
				lazer[flag - 1] += lazer[flag];
			}
			lazer[flag] = 0;
			flag--;
		}
		subset(index + 1);
	}
}
