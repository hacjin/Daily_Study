package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2661_좋은수열 {
	static int N;
	static StringBuilder sb;
	static String res;
	static boolean dup;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		permutation(0);
		System.out.println(res);

	}

	public static void permutation(int index) {
		if (index == N) {
			if (res == null) {
				res = sb.toString();
			} else {
				if (Integer.parseInt(res) > Integer.parseInt(sb.toString())) {
					res = sb.toString();
				}
			}
			sb.deleteCharAt(index - 1);
			return;
		}
		while (true) {
			for (int i = 1; i <= 3; i++) {
				if (sb == null) {
					sb = new StringBuilder();
					sb.append(i);
					index++;
				} else {
					if(sb.length()/2 > 0) {
						for (int j = 1; j <= sb.length()/2+1; j++) {
							if (sb.charAt(sb.length() - j) - '0' != i) {
								dup = true;
							}else {
								dup = false;
							}
						}
						if (dup) {
							sb.append(i);
							dup = false;
							permutation(index + 1);
						}
					}
					else {
						if (sb.charAt(sb.length() - 1) - '0' != i) {
							sb.append(i);
							permutation(index + 1);
						}
					}
				}
			}
			break;
		}
		sb.deleteCharAt(index - 1);
	}
}
