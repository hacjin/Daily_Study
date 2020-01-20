package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B16236_아기상어_BFS_강사님 {
	
	static int N, map[][], SX,SY, SIZE;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static final int NO=100;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		SIZE = 2;
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					SX = i;
					SY = j;
					map[i][j] = 0;
				} // 상어위치 확인 후 빈칸 처리
			}
		}
		int times = 0,count=0;
		while(true) {
			int[] fish = getFishes();
			if(fish[2] == -1) break; //먹을 물고기 없음.
			
			if(++count==SIZE) {
				++SIZE;
				count = 0;
			}
			SX = fish[0];
			SY = fish[1];
			times += fish[2];
			map[SX][SY] = 0;
		}
		System.out.println(times);
	}
	private static int[] getFishes() {
		int[] fish = {NO,NO,-1};
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][N];
		visited[SX][SY] = true;
		queue.offer(new int[] {SX,SY,0});
		
		int[] cur = null;
		int newX=0,newY=0,qSize = 0;
		int minX=NO,minY=NO,minD=Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			qSize = queue.size();
			while(qSize-->0) {
				cur = queue.poll();	
				for (int d = 0; d < 4; ++d) {
					newX = cur[0] + dx[d];
					newY = cur[1] + dy[d];
					if(newX>=0 && newX<N && newY>=0 && newY<N 
							&& !visited[newX][newY] && map[newX][newY] <= SIZE) {
						if(map[newX][newY]==0 || map[newX][newY]==SIZE) { // 빈칸이거나 지나가는 물고기이면
							visited[newX][newY] = true;	
							queue.offer(new int[] {newX,newY, cur[2]+1});
						}else { // 잡아먹을수 있는 물고기이면
							minD = cur[2]+1;
							if(minX > newX) {
								minX = newX;
								minY = newY;
							}else if(minX == newX) {
								if(minY>newY) minY = newY;
							}
						}
					}
				}
			} // 동일 너비 처리
			if(minD < Integer.MAX_VALUE) {
				fish[0] = minX;
				fish[1] = minY;
				fish[2] = minD;
				break;
			}
		}// end queue while
		
		return fish;
	}
}
