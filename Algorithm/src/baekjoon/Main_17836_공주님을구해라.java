package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17836_공주님을구해라 {
	static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static int N,M,T;
	static int min = 10001, sp=10001, ep=10001;
	static int map[][];
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		int pr=0,pc=0;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==2) {
					pr = r;
					pc = c;
				}
			}
		}
		bfs(0,0,0,1);
		bfs(pr,pc,0,2);
		bfs(0,0,0,3);
		min = Math.min(min, sp+ep);
		System.out.println(min>T?"Fail":min);
	}
	private static void bfs(int sr, int sc,int t,int chk) {
		visit = new boolean[N][M];
		Queue<int[]> que = new LinkedList<>();
		visit[sr][sc]=true;
		que.add(new int[] {sr,sc, t});
	prin:while(!que.isEmpty()) {
			int[] q = que.poll();
			int r = q[0];
			int c = q[1];
			int cnt = q[2];
			int nr,nc;
			for (int d = 0; d < dir.length; d++) {
				nr = r + dir[d][0];
				nc = c + dir[d][1];
				if(nr==N-1 && nc==M-1) {
					if(chk==3 && min>cnt+1) min = cnt+1;
					else if(chk==2 && ep > cnt+1 ){
						ep = cnt+1;
					}
					break prin;
				}
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					if(chk==1 && map[nr][nc]>1) {
						if(sp > cnt+1) {
							sp = cnt+1;
							break prin;
						}
					}
					
					if(!visit[nr][nc]) {
						if(chk==2) {
							visit[nr][nc] = true;
							que.add(new int[] {nr,nc,cnt+1});
						}else {
							 if(map[nr][nc]==0) {
								visit[nr][nc] = true;
								que.add(new int[] {nr,nc,cnt+1});
							 }
						}
					}
				}
			}
		}
	}
}
