package 미해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_B2665_미로만들기 {
	static int dir[][] = new int[][] {{1,0},{0,1}}; // 상, 하, 좌, 우
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int map[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				map[i][j] = input[j]-'0';
			}
		}
		boolean visit[][] = new boolean[n][n];
		bfs(0,0,n,map,visit);
		System.out.println(result);
	}

	private static void bfs(int r, int c, int n, int[][] map,boolean[][] visit) {
		int[][] cnt = new int[n][n];
		for (int i = 0; i < cnt.length; i++) {
			Arrays.fill(cnt[i], Integer.MAX_VALUE);
		}
		cnt[0][0] = 0;
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {r,c});
		visit[r][c] = true;
		while(!que.isEmpty()) {
			int cur[] = que.poll();
			int cr = cur[0];
			int cc = cur[1];
			int val = cnt[cr][cc];
			for (int i = 0; i < dir.length; i++) {
				int nr = cr + dir[i][0];
				int nc = cc + dir[i][1];
				if(nr>=0 && nc>=0 && nr < n && nc<n) {  
					if(map[nr][nc]<1) {
						if(cnt[nr][nc] > val+1) cnt[nr][nc] = val+1;
					}else {
						if(cnt[nr][nc] > val) cnt[nr][nc] = val;
					}
					if(!visit[nr][nc]) {
						que.add(new int[] {nr,nc});
						visit[nr][nc] = true;
					}
				}
			}
		}
		result = cnt[n-1][n-1];
	}
}
