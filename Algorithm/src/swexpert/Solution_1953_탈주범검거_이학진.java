package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거_이학진 {
	static int dir[][] = {{-1,0},{0,-1},{0,1},{1,0}};	// 상,좌,우,하
	static int v[][] = { {0,1,2,3},{0,3},{1,2},{0,2},{3,2},{1,3},{1,0}};
	static int map[][],N,M;
	static boolean visit[][];
	static int L,res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visit = new boolean[N][M];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int c = 0; c < M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			visit[R][C] = true;
			res = 0;
			run(R,C,1);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(visit[i][j]) res++;
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}
	private static void run(int r, int c, int t) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] { r,c,t });
		while(!que.isEmpty()) {
			int tmp[] = que.poll();
			int cr = tmp[0];
			int cc = tmp[1];
			int ct = tmp[2];
			int cd = map[cr][cc]-1;
			if(cd<0 || ct==L) continue;
			int nr,nc;
			for (int d = 0; d < v[cd].length; d++) {
				int index = v[cd][d];
				nr = cr + dir[index][0];
				nc = cc + dir[index][1];
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					if(!visit[nr][nc] && map[nr][nc]>0) {
						int tm = map[nr][nc]-1;
						for (int i = 0; i < v[tm].length; i++) {
							if(index==Math.abs(3-v[tm][i])) {
								visit[nr][nc] = true;
								que.add(new int[] {nr,nc,ct+1});
								break;
							}
						}
					}
				}
			}
		}
	}
}
