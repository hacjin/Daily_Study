package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2999_비밀이메일 {
	static char map[][], res[][];
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = br.readLine();
		int N = in.length();
		
		C = (int)Math.sqrt(N);
		R = C;
		while (R<=C) {
			if(R*C==N) break;
			C++;
			R=C;
			while(R!=1) {
				if(R*C==N) break;
				R--;
			}
		}
		/*for (int i = 1; i <= N; i++) {
			if(N%i==0 && i <= N/i) {
				R = i;
				C = N/i;
			}
		}*/
		
		map = new char[R][C];
		res = new char[R][C];
		int index = 0;
		for (int c = 0; c < C; c++) {
			for (int r = 0; r < R; r++) {
				res[r][c] = in.charAt(index++);
			}
		}

		for (char ch[] : res) {
			for (char c : ch) {
				System.out.print(c);
			}
		}
	}
}
