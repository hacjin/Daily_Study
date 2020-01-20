package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설_이학진 {
	static int map[][];
	static int N,x,result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			result = 0;
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt,cg;
			boolean chk;
			for (int r = 0; r < N; r++) {
				cnt = 1;
				cg = 0;
				chk = true;
				for (int c = 0; c < N-1; c++) {
					if(Math.abs(map[r][c]-map[r][c+1])>1) {
						chk = false;
						break;
					}
					if(map[r][c]==map[r][c+1]) cnt++;
					else if(map[r][c] < map[r][c+1]) {
						if(cnt<x) {
							chk = false;
							break;
						}else {
							if(cg>0 && cnt/x < 2) {
								chk = false;
								break;
							}
						}
						cnt = 1;
						cg = 0;
					}else {
						if(cg>0 && cnt<x) {
							chk = false;
							break;
						}
						cnt = 1;
						cg = 1;
					}
				}
				if(cg>0 && cnt<x ) chk = false;
				if(chk) result++;
			}
			for (int c = 0; c < N; c++) {
				cnt = 1;
				cg = 0;
				chk = true;
				for (int r = 0; r < N-1; r++) {
					if(Math.abs(map[r][c]-map[r+1][c])>1) {
						chk = false;
						break;
					}
					if(map[r][c]==map[r+1][c]) cnt++;
					else if(map[r][c] < map[r+1][c]) {
						if(cnt<x) {
							chk = false;
							break;
						}else {
							if(cg>0 && cnt/x < 2) {
								chk = false;
								break;
							}
						}
						cnt = 1;
						cg = 0;
					}else {
						if(cg>0 && cnt<x) {
							chk = false;
							break;
						}
						cnt = 1;
						cg = 1;
					}
				}
				if(cg>0 && cnt<x ) chk = false;
				if(chk) result++;
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
