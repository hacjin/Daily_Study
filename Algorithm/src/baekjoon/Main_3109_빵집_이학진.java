package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집_이학진 {
	static int dir[][] = {{-1,1},{0,1},{1,1}};		// 동북 , 동 , 동남
	static boolean visit[][],chk;
	static int R,C;
	static char map[][];
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		
		for (int r = 0; r < R; r++) {
			String in = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = in.charAt(c);
			}
		}
		
		for (int r = 0; r < R; r++) {
			chk=false;
			dfs(r,0);
		}
		System.out.println(res);
	}
	private static void dfs(int r, int c) {
		if(c == C-1) {
			chk=true;
			res++;
			return;
		}
		visit[r][c] = true;
		int nr,nc;
		for (int d = 0; d < 3; d++) {
			nr = r +dir[d][0];
			nc = c +dir[d][1];
			if(nr>=0 && nr<R && nc>=0 && nc<C) {
				if(!visit[nr][nc] && map[nr][nc]=='.') {
					dfs(nr,nc);
					if(chk) return;
				}
			}
		}
	}
}
