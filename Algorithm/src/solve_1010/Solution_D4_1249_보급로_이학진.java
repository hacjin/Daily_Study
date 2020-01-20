package solve_1010;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_1249_보급로_이학진 {
	static final int INF = 1000000;
	static int T,N;
	static int map[][],tmp[][];
	static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static Queue<int[]> que;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N= Integer.parseInt(br.readLine());
			map = new int[N][N];
			tmp = new int[N][N];
			for (int[] tm : tmp) {
				Arrays.fill(tm, INF);
			}
			for (int r = 0; r < N; r++) {
				String str = br.readLine();
				for (int c = 0; c < N; c++) {
					map[r][c] = str.charAt(c)-'0';
				}
			}
			que = new LinkedList<int[]>();
			que.add(new int[] {0,0,0});
			bfs();
			System.out.println("#"+t+" "+tmp[N-1][N-1]);
		}
	}
	private static void bfs() {
		int r,c,w=0;
		int nr,nc;
		while(!que.isEmpty()) {
			r = que.peek()[0];
			c = que.peek()[1];
			w = que.peek()[2];
			que.poll();
			for (int d = 0; d < dir.length; d++) {
				nr = r+dir[d][0];
				nc = c+dir[d][1];
				if(nr>=0 && nc>=0 && nr<N && nc < N) {
					if(tmp[nr][nc] > w+map[nr][nc]) {
						que.add(new int[] {nr,nc,w+map[nr][nc]});
						tmp[nr][nc] = w+map[nr][nc];
					}
				}
			}
		}
	}
}
