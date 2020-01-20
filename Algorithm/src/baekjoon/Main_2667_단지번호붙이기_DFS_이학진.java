package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2667_단지번호붙이기_DFS_이학진 {
	static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};	// 0: 우 	1: 하	2:좌		3:상
	static boolean visit[][];
	static int N,resCnt;
	static int map[][],tmp[][],res[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		tmp = new int[N][N];
		visit = new boolean[N][N];
		
		resCnt=0;
		for (int r = 0; r < N; r++) {
			st = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = st.charAt(c)-'0';
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c]==1 && !visit[r][c]) {
					resCnt++;
					visit[r][c] = true;
					tmp[r][c] = resCnt;
					move(r,c);
				}
			}
		}
		res= new int[resCnt+1];
		for (int i = 1; i <=resCnt; i++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(tmp[r][c]==i) {
						res[i]++;
					}
				}
			}
		}
		int tmp;
		for (int i = 1; i < resCnt; i++) {
			for (int j = i+1; j <= resCnt; j++) {
				tmp = res[i];
				if(res[j] <= res[i]) {
					res[i] = res[j];
					res[j] = tmp;
				}
			}
		}
		System.out.println(resCnt);
		for (int i = 1; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
	private static void move(int r, int c) {
		int nr,nc;
		
		for (int i = 0; i < 4; i++) {
			nr = r+ dir[i][0];
			nc = c + dir[i][1];
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				if(!visit[nr][nc] && map[nr][nc]==1) {
					visit[nr][nc] = true;
					tmp[nr][nc] = resCnt;
					move(nr,nc);
				}
			}
		}
	}
}
