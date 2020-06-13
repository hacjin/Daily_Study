package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2636_치즈_이학진 {
	static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static boolean visit[][];
	static int R,C,map[][],cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int t = 0,zero;
		while(true) {
			t++;
			zero = 0;
			visit = new boolean[R][C];
			bfs(0,0);
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(map[r][c]==1) zero++;
				}
			}
			if(zero==0) break;
		}
		System.out.println(t+"\n"+cnt);
	}

	private static void bfs(int r, int c) {
		cnt = 0;
		LinkedList<int[]> que = new LinkedList<int[]>();
		visit[r][c] = true;
		que.add(new int[]{r,c});
		
		while(!que.isEmpty()) {
			int[] tmp = que.poll();
			int nr, nc;
			for (int d = 0; d < dir.length; d++) {
				nr = tmp[0]+dir[d][0];
				nc = tmp[1]+dir[d][1];
				if(nr>=0 && nr<R && nc>=0 && nc<C) {
					if(!visit[nr][nc] && map[nr][nc]==0) {
						visit[nr][nc] = true;
						que.add(new int[] {nr,nc});
					}
					if(!visit[nr][nc] && map[nr][nc]==1) {
						visit[nr][nc] = true;
						map[nr][nc] = 0;
						cnt++;
					}
				}
			}
		}
	}
}
