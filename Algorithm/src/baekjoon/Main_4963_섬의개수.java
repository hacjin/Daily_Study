package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {
	static int dir[][] = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
	// 동 동남 남 남서 서 북서 북 북동
	static boolean visit[][];
	static int W, H, res;
	static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			res = 0;
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if (W == 0 && H==0) { break; }
			map = new int[H][W];
			visit = new boolean[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(!visit[i][j] && map[i][j]==1) {
						DFS(i, j);
						res++;
					}
				}
			}
			System.out.println(res);
		}
	}

	private static void DFS(int r, int c) {
		visit[r][c] = true;
		int nr, nc;
		for (int k = 0; k < 8; k++) {
			nr = r + dir[k][0];
			nc = c + dir[k][1];
			if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
				if(!visit[nr][nc] && map[nr][nc]==1) {
					DFS(nr,nc);
				}
			}
		}
	}
}
