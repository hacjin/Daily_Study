package solve_1010;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_D4_1249_보급로_강사님 {
	static int N = 0, INF = 1000000;
	static int matrix[][], time[][];
	static int dr[] = {0,1,0,-1};
	static int dc[] = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			matrix = new int[N][N];
			time = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				String s = br.readLine();
				for (int c = 0; c < N; c++) {
					matrix[r][c] = s.charAt(c)-'0';
					time[r][c] = INF;
				}
			}
			
			go(0,0);
			System.out.println("#"+t+" "+time[N-1][N-1]);
		}
		
	}
	private static void go(int a, int b) {
		PriorityQueue<int[]> que = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});	
		time[a][b] = 0;
		que.offer(new int[] {a,b,time[a][b]});
		
		int r,c,cost,nr,nc;
		while(true) {
			int[] temp = que.poll();
			r = temp[0];
			c = temp[1];
			cost = temp[2];
			
			if(r == N-1 && c == N-1) return;
			
			for (int d = 0; d < 4; d++) {
				nr = r+dr[d];
				nc = c+dc[d];
				if(nr>=0 && nc>=0 && nr<N && nc<N && time[nr][nc] > cost+matrix[nr][nc]) {
					time[nr][nc] = cost+matrix[nr][nc];
					que.offer(new int[] {nr,nc,time[nr][nc]});
				}
			}
		}
	}
}
