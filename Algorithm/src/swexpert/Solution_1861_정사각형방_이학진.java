package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방_이학진 {
	static int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}}; // 동 서 남 북
	static boolean visit[][];
	static int map[][];
	static int N,cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			int max=0,rn=N*N;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					visit[r][c] = true;
					cnt=1;
					dfs(r,c);
					visit[r][c] = false;
					if(cnt>=max) {
						if(cnt==max && rn > map[r][c]) {
							rn = map[r][c];
						}
						if(cnt>max){
							rn = map[r][c];
						}
						max = cnt;
					}
				}
			}
			System.out.println("#"+t+" "+rn+" "+max);
		}
	}
	private static void dfs(int r, int c) {
		int nr,nc;
		for (int d = 0; d < 4; d++) {
			nr = r + dir[d][0];
			nc = c + dir[d][1];
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				if(map[nr][nc]-1 == map[r][c]) {
					visit[nr][nc] = true;
					cnt++;
					dfs(nr,nc);
					visit[nr][nc] = true;
				}
			}
		}
	}
}
