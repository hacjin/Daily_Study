package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1215_회문 {
	static int N;		// 회문 길이
	static char map[][] = new char[8][8];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st;
		int cnt,chk;
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			for (int r = 0; r < 8; r++) {
				st = br.readLine();
				for (int c = 0; c < 8; c++) {
					map[r][c] = st.charAt(c);
				}
			}
			cnt =0;
			for (int r = 0; r < 8; r++) {
				for (int c = 0; c < 8-N+1; c++) {
					chk =0;
					for (int i = 0; i < N ; i++) {
						if(map[r][c+i] == map[r][c+N-1-i]) {
							chk++;
						}
					}
					if(chk==N) {
						cnt++;
					}
				}
			}
			for (int r = 0; r < 8-N+1; r++) {
				for (int c = 0; c < 8; c++) {
					chk =0;
					for (int i = 0; i < N ; i++) {
						if(map[r+i][c] == map[r+N-1-i][c]) {
							chk++;
						}
					}
					if(chk==N) {
						cnt++;
					}
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}
