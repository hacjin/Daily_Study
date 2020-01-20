package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {
	static int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};	// 동 서 남 북
	static int N;
	static int map[][];
	static boolean visit[][];
	static int size,sizecnt;
	static int res;
	static Queue<int[]> que;
	static int SX,SY;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map = new int[N][N];
		size = 2;
		
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==9) {
					SX=r;
					SY=c;
					map[r][c] = 0;
				}
			}
		}
		res = 0;
		sizecnt=0;
		
		while(true) {
			int [] fish = bfs();
			if(fish[2] == -1) break;
			
			if(++sizecnt == size) {
				++size;
				sizecnt=0;
			}
			SX=fish[0];
			SY=fish[1];
			res += fish[2];
			map[SX][SY]=0;
		}
		System.out.println(res);
	}
	private static int[] bfs() {
		int fish[] = {100,100,-1};
		que = new LinkedList<int[]>();
		visit = new boolean[N][N];
		visit[SX][SY] = true;
		que.add(new int[] {SX,SY,0});
		int cur[] = null;
		int nr,nc;
		int minr=100,minc=100,minv=Integer.MAX_VALUE;
		while(!que.isEmpty()) {
			int qsize = que.size();
			while(qsize-->0) {
				cur = que.remove();
				for (int d = 0; d < 4; d++) {
					nr = cur[0] + dir[d][0];
					nc = cur[1] + dir[d][1];
					if(nr>=0 && nr<N && nc>=0 && nc<N && !visit[nr][nc]) {
						if(map[nr][nc]==0 ||map[nr][nc]==size) {
							visit[nr][nc]=true;
							que.add(new int[] {nr,nc,cur[2]+1});
						}else if(map[nr][nc]<size) {
							minv = cur[2]+1;
							if(minr > nr) {
								minr = nr;
								minc = nc;
							}else if(minr == nr) {
								if(minc>nc) minc=nc;
							}
						}
					}
				}
			}
			if(minv < Integer.MAX_VALUE) {
				fish[0] = minr;
				fish[1] = minc;
				fish[2] = minv;
				break;
			}
		}
		return fish;
	}
}
