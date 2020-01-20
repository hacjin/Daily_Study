package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1868_파핑파핑지뢰찾기 {
	static int dir[][] = {{-1,0},{-1,1},{0,1},{1,1}		// 북 북동 동 동남
						 ,{1,0},{1,-1},{0,-1},{-1,-1}}; // 남 남서 서 북서
	static char boom[][];
	static int cntboom[][];
	static boolean visit[][];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			boom = new char[N][N];
			cntboom = new int[N][N];
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				boom[i] = br.readLine().toCharArray();
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(boom[i][j]=='*') {
						visit[i][j] = true;
						pluscnt(i,j);
					}
				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visit[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
	private static void bfs(int i, int j) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {i,j});
		visit[i][j] = true;
		int zero=0;
		while(!que.isEmpty()) {
			int[] tmp = que.poll();
			int r = tmp[0];
			int c = tmp[1];
			int val = cntboom[r][c];
			for (int d = 0; d < dir.length; d++) {
				int nr = r + dir[d][0];
				int nc = c + dir[d][1];
				if(nr>=0 && nr<N && nc>=0 &&nc<N) {
					if(val==0 && !visit[nr][nc]) {
						zero++;
						visit[nr][nc] = true;
						que.add(new int[] {nr,nc});
					}
					if(zero==0 && cntboom[nr][nc]==0 && !visit[nr][nc]) {
						visit[nr][nc] = true;
						que.add(new int[] {nr,nc});
					}
				}
			}
		} 
	}
	private static void pluscnt(int r, int c) {
		cntboom[r][c] = N+2;
		int nr,nc;

		for (int d = 0; d < dir.length; d++) {
			nr = r + dir[d][0];
			nc = c + dir[d][1];
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				if(boom[nr][nc]=='.') cntboom[nr][nc]+=1;
			}
		}
	}
}
