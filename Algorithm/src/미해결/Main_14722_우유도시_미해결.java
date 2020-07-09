package 미해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14722_우유도시_미해결 {
	static int N,max;
	static int dir[][] = {{0,1},{1,0}}; // 동, 남
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int map[][];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		max = 0;
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(map[0][0]==0) dfs(0,0,1,map);
		else dfs(0,0,0,map);
		
		System.out.println(max);
	}
	private static void dfs(int i, int j, int cnt, int[][] map) {
		if(cnt==0) {
			for (int k = 0; k < dir.length; k++) {
				int nr = i + dir[k][0];
				int nc = j + dir[k][1];
				if(nr>=0 && nc>=0 && nr<N && nc <N) {
					if(map[nr][nc]==0) dfs(nr,nc,cnt+1,map);
					else dfs(nr,nc,cnt,map);
				}
			}
		}else {
			for (int k = 0; k < dir.length; k++) {
				int nr = i + dir[k][0];
				int nc = j + dir[k][1];
				if(nr>=0 && nc>=0 && nr<N && nc <N) {
					if(map[nr][nc]==(map[i][j]+1)%3) dfs(nr,nc,cnt+1,map);
					else if(map[nr][nc]==map[i][j])dfs(nr,nc,cnt,map);
				}
			}
		}
		if(max < cnt) max =cnt;
	}
}
