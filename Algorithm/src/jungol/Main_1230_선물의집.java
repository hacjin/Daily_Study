package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1230_선물의집 {
	static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static int N,res;
	static int map[][];
	static boolean visit[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c]= Integer.parseInt(st.nextToken());
			}
		}
		
		if(map[0][0]==2) {
			move(0,0,1);
		}else {
			move(0,0,0);
		}
			
		System.out.println(res);
	}
	private static void move(int r, int c,int cnt) {
		visit[r][c] = true;
		
		if(r==N-1&&c==N-1) {
			if(res<cnt) {
				res = cnt;
			}
			visit[r][c]=false;
			return;
		}
		int nr, nc;
		for (int d = 0; d < 4; d++) {
			nr = r + dir[d][0];
			nc = c + dir[d][1];
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				if(map[nr][nc]==0 && !visit[nr][nc]) {
					move(nr,nc,cnt);
				}else if(map[nr][nc]==2 && !visit[nr][nc]) {
					move(nr,nc,cnt+1);
				}
			}
		}
		visit[r][c] = false;
	}
}
