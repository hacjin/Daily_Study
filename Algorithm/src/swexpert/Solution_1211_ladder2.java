package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1211_ladder2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};	// 0:북 1:동 2:남 3:서
		int T,N = 100;
		int map[][] = new int[N][N];
		for (int t = 1; t < 10; t++) {
			T = Integer.parseInt(br.readLine());
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
//			========================= 입력 끝 =========================
			int move,d,res[]=new int[N],tmp=0;
			int nr=0,nc=0;
			for (int c = 0; c < N; c++) {
				move=0;
				d = 2;
				if(map[0][c]==1) {
					nr = 0;
					nc = c;
				}
				while(true) {
					if(map[nr+dir[d-1][0]][nc+dir[d-1][1]] == 1) {
						nr = nr+dir[d-1][0];
						nc = nc+dir[d-1][1];
					}else if(map[nr+dir[d+1][0]][nc+dir[d+1][1]] == 1) {
						nr = nr+dir[d+1][0];
						nc = nc+dir[d+1][1];
					}else {
						nr = nr + dir[d][0];
						nc = nc + dir[d][1];
					}
					if(nr<=N || nc<=N) {
						move++;
					}else {
						break;
					}
				}
				if(tmp < move) {
					tmp = move;
					res[c] = move;	// index 배열에 거리값을 할당
				}
			}
		}
	}
}
