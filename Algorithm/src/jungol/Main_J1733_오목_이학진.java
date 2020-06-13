package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_J1733_오목_이학진 {
	static int dir[][] = {{-1,1},{0,1},{1,1},{1,0} };
	static final int  N = 19;
	static int map[][];
	static int visit[][];
	static int result[];
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		visit = new int[N][N];
		result = new int[3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean chk = false;
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				int val = map[i][j];
				if(val>0) {
					for (int d = 0; d < dir.length; d++) {
						cnt = 1;
						dfs(i,j,val,d);
						if(visit[i][j]<cnt) visit[i][j] = cnt;
						if(visit[i][j]==5) {
							result[0] = map[i][j];
							result[1] = i+1;
							result[2] = j+1;
							chk = true;
							break;
						}
						cnt=1;
					}
				}
				if(chk) break;
			}
			if(chk) break;
		}
		if(result[0]==0) System.out.println(0);
		else {
			System.out.print(result[0]+"\n"+result[1]+" "+result[2]);
		}
	}
	private static void dfs(int r, int c, int val,int d) {
		int nr, nc;
		nr = r+ dir[d][0];
		nc = c+ dir[d][1];
		if(nr>=0 && nc>=0 && nr<N && nc<N) {
			if(map[nr][nc]==val) {
				cnt++;
				dfs(nr,nc,val,d);
				if(visit[nr][nc]<cnt) visit[nr][nc] = cnt;
			}
		}
	}
}
