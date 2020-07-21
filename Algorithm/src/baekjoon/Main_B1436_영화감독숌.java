package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1436_영화감독숌 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int s = 666;
		int cnt = 1;
		if (N == 1)
			System.out.println(s);
		else {
			s++;
			while (true) {
				int tmp = s;
				int chk = 0;
				while (tmp > 0) {
					int mod = tmp % 10;
					if (mod == 6)
						chk++;
					if (chk<3 && mod != 6) {
						chk = 0;
					}
					tmp = tmp / 10;
				}
				if (chk >= 3) {
					++cnt;
					if (cnt == N) {
						System.out.println(s);
						break;
					}
				}
				s++;
			}
		}
	}
}
