package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1726_로봇 {
	static int dir[][] = { { 0, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // 1: 동쪽 2: 서쪽 3: 남쪽 4: 북쪽
	static int map[][];
	static Queue<Integer> que = new LinkedList<Integer>();
	static int min = 10000;
	static int sx, sy, sd, ex, ey, ed;
	static int N, M;
	static boolean visit[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken())-1;
		sy = Integer.parseInt(st.nextToken())-1;
		sd = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken())-1;
		ey = Integer.parseInt(st.nextToken())-1;
		ed = Integer.parseInt(st.nextToken());

		int nx = sx, ny = sy, nd = sd,c=0;
		visit[nx][ny] = true;
		while (nx != ex || ny != ey) {
			searchNode(nx, ny, nd, c); // 현재 위치에서 인접한 노드가 0인 노드 탐색후 que에 삽입
			nx = que.poll();
			ny = que.poll();
			nd = que.poll();
			c = que.poll();
		}
		System.out.println(min);
	}

	public static void searchNode(int nx, int ny, int nd,int c) {
		int count;
		for (int d = 1; d < 5; d++) {
			count = 0;
			nx = nx + dir[d][0];
			ny = ny + dir[d][1];
			if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
				if (map[nx][ny] == 0 && !visit[nx][ny]) { // 이웃 노드 즉 갈수있는 0인 구역 탐색 후 x,y,d를 que에 삽입\
					if (nx!=ex || ny!=ey || nd != ed) {
						if (nd == 1) { // 방향 전환시 이동수 증가 start
							if (nd - d == -2 || nd - d == -3) {
								count = c + 1;
							} else {
								count = c + 2;
							}
						} else if (nd == 2) {
							if (nd - d == -2 || nd - d == -1) {
								count = c + 1;
							} else {
								count = c + 2;
							}
						} else if (nd == 3) {
							if (nd - d == 2 || nd - d == 1) {
								count = c + 1;
							} else {
								count = c + 2;
							}
						} else if (nd == 4) {
							if (nd - d == 3 || nd - d == 2) {
								count = c + 1;
							} else {
								count = c + 2;
							}
						} // 방향 전환시 이동수 증가 end
					}
					que.add(nx);
					que.add(ny);
					que.add(d);
					que.add(count);
					visit[nx][ny] = true;
					if (nx == ex && ny == ey) {
						if (count < min) {
							min = count;
						}
					}
				}
				nx = nx - dir[d][0];
				ny = ny - dir[d][1];
			}else {
				nx = nx - dir[d][0];
				ny = ny - dir[d][1];
			}
		}
	}
}
