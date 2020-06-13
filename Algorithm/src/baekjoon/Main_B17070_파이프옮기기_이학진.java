package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B17070_파이프옮기기_이학진 {
	static int dir[][] = {{0,1},{1,0},{1,1}};
	static int N,cnt;
	static int map[][];
	static boolean visit[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		visit[0][1] = true;
		dfs(0,1,0);
		System.out.println(cnt);
	}
	private static void dfs(int r, int c, int cd) {
		if(r==N-1 && c==N-1) {
			if(map[N-1][N-1]==0) cnt++;
			return;
		}
		int nr,nc;
		for (int d = 0; d < dir.length; d++) {
			if(cd==0 && d!=1 || cd==1 && d!=0 || cd==2) {
				nr = r + dir[d][0];
				nc = c + dir[d][1];
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					if(!visit[nr][nc]) {
						if(d==2) {
							if(map[nr-1][nc]==0 && map[nr][nc-1]==0 && map[nr][nc]==0) {
								visit[nr][nc] = true;
								dfs(nr,nc,d);
								visit[nr][nc] = false;
							}
						}else {
							if(map[nr][nc]==0) {
								visit[nr][nc] = true;;
								dfs(nr,nc,d);
								visit[nr][nc] = false;
							}
						}
					}
				}
			}
		}
	}
}
