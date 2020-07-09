package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 최단 거리를 구하는 문제!!
 * 다리간 격차가 가장 최소인 거리를 출력하라.
 * 1개의 섬을 기준으로 다른 섬까지 도달하는 거리가 가장 작은 결과를 출력하므로 BFS를 통한 너비 탐색으로
 * 1이라는 섬을 만났을 시 최소거리를 바로 출력?!
 * 섬마다 거리를 측정해보아야한다.
 */
public class Main_2146_다리만들기 {
	static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상 하 좌 우
	static boolean visit[][];
	static int N, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int map[][];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		min = 10000;
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					ArrayList<int[]> around = new ArrayList<>();
					find(i, j, map, around);
					for (int k = 0; k < around.size(); k++) {
						int[] tmp = around.get(k);
						boolean[][] save = new boolean[N][N];
						for (int l = 0; l < save.length; l++) {
							for (int m = 0; m < save.length; m++) {
								save[l][m] = visit[l][m];
							}
						}
						root(tmp[0], tmp[1], map, save);
					}
				}
			}
		}
		System.out.println(min);
	}

	private static void root(int r, int c, int[][] map, boolean[][] save) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { r, c, 0 });
		save[r][c] = true;
		while (!que.isEmpty()) {
			int[] tmp = que.poll();
			r = tmp[0];
			c = tmp[1];
			int cnt = tmp[2];
			for (int j = 0; j < dir.length; j++) {
				int nr = r + dir[j][0];
				int nc = c + dir[j][1];
				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !save[nr][nc]) {
					if(map[nr][nc]==0) {
						que.add(new int[] {nr,nc,cnt+1});
						save[nr][nc] = true;
					}else {
						if(min>cnt) { 
							min=cnt;
						}
					}
				}
			}
		}
	}

	private static void find(int i, int j, int[][] map, ArrayList<int[]> around) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { i, j });
		visit[i][j] = true;

		while (!que.isEmpty()) {
			int tmp[] = que.poll();
			int r = tmp[0];
			int c = tmp[1];
			boolean zero = true;
			for (int k = 0; k < dir.length; k++) {
				int nr = r + dir[k][0];
				int nc = c + dir[k][1];

				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visit[nr][nc]) {
					if (map[nr][nc] == 1) {
						que.add(new int[] { nr, nc });
						visit[nr][nc] = true;
					} else {
						zero = false;
					}
				}
			}
			if (!zero)
				around.add(new int[] { r, c });
		}
	}
}
