package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	static int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}}; // 동 서 남 북
	static boolean visit[][];
	static int R,C;
	static int map[][];
	static int count;
	static Queue<int[]> que;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int t=0,precnt=0;
		count=countOne();
		while(count>0) {
			que = new LinkedList<int[]>();
			visit = new boolean[R][C];
			precnt=count;
			bfs(0,0);
			t++;
			count=countOne();
		}
		System.out.print(t+"\n"+precnt);
	}
	private static void bfs(int r, int c) {
		visit[r][c] = true;
		que.add(new int[] {r,c});
		int nr,nc;
		while(!que.isEmpty()) {
			int qsize = que.size();
			while(qsize-->0) {
				int data[] = que.remove();
				for (int d = 0; d < 4; d++) {
					nr = data[0] + dir[d][0];
					nc = data[1] + dir[d][1];
					if(nr>=0 && nr<R && nc>=0 && nc<C) {
						if(map[nr][nc]==1) {
							visit[nr][nc]=true;
							map[nr][nc]=0;
						}
						if(!visit[nr][nc]&&map[nr][nc]==0) {
							visit[nr][nc]=true;
							que.add(new int[] {nr,nc});
						}
					}
				}
			}
		}
	}
	private static int countOne() {
		int count = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c]==1) count++;
			}
		}
		return count;
	}
}
