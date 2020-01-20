package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1209_Sum {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int dir[][] = { { 0, 1 }, { 1, 0 }, { 1, 1 } }; // 1: 열 2: 행 3:대각선
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int R = 100, C = 100, T;
		int map[][] = new int[R][C];
		int max[] = new int[3];
		int res = 0;

		for (int t = 1; t <= 10; t++) {
			T = Integer.parseInt(br.readLine());
			max[0] = 0;
			max[1] = 0;
			max[2] = 0;
			res = 0;
			
			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < C; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int r = 0; r < R; r++) {
				if(max[0]>=res) {
					res = max[0];
				}
				max[0] = 0;
				for (int c = 0; c < C; c++) {
					 max[0] += map[r][c];
				}
			}
			
			for (int r = 0; r < R; r++) {
				if(max[1]>=res) {
					res = max[1];
				}
				max[1]=0;
				for (int c = 0; c < C; c++) {
					 max[1] += map[c][r];
				}
			}
			int nr=0,nc=0;
			while(true) {
				if(nr==R || nc==C) break;
				else {
					max[2] += map[nr][nc];
					nr = nr + dir[2][0];
					nc = nc + dir[2][1];
				}
			}
			
			if(max[2]>=res ) {
				res = max[2];
			}
			
			System.out.println("#" + t + " " + res);
		}
	}
}
