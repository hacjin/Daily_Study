package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2105_디저트카페_이학진 {
	static int dir[][] = {{1,1},{1,-1},{-1,-1},{-1,1}};
	static int N,map[][];
	static int max,br,bc;
	static boolean tmp[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bfr.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(bfr.readLine());
			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(bfr.readLine()," ");
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = -1;
			tmp = new boolean[101];
			for (int r = 0; r < N-2; r++) {
				for (int c = 1; c < N-1; c++) {
					tmp[map[r][c]]=true;
					br = r;
					bc = c;
					dfs(r,c,r,c,1,0);
					tmp[map[r][c]]=false;
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}
	private static void dfs(int r, int c, int pr,int pc,int cnt,int d) {
		for (int dd = d; dd < dir.length; dd++) {
			if(cnt==1 && dd>0) return;
			int nr = r+ dir[dd][0];
			int nc = c+ dir[dd][1];
			if(nr>=0 && nc>=0 && nr<N && nc<N) {
				if(!tmp[map[nr][nc]]) {
					tmp[map[nr][nc]]=true;
					dfs(nr,nc,r,c,cnt+1,dd);
					tmp[map[nr][nc]]=false;
				}else {
					if(cnt>2 && nr==br && nc==bc) {
						if(max<cnt) max = cnt;
						return;
					}
					if(nr==pr && nc==pc) return;
				}
			}
		}
	}
}
