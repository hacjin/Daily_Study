package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기_이학진 {
	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int map[][];
	static int N, W, H;
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			for (int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int c = 0; c < W; c++) {
					int tp = Integer.parseInt(st.nextToken());
					map[r][c] = tp;
				}
			}
			res = 200;
			all(0);
			System.out.println("#"+t+" "+res);
		}
	}

	private static void all(int cnt) {
		if (cnt == N) {
			int mincnt = 0;
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					if(map[r][c]!=0) mincnt++;
				}
			}
			if(res > mincnt) res = mincnt;
			return;
		}
		int tmp[][] = new int[H][W];
		init(tmp);
		for (int c = 0; c < W; c++) {
			for (int r = 0; r < H; r++) {
				if (map[r][c] > 0) {
					int tp = map[r][c];
					around(r,c,tp-1);
					break;
				}
			}
			push();
			all(cnt + 1);
			reinit(tmp);
		}
	}
	private static void around(int r, int c, int val) {
		map[r][c] = 0; 
		for (int d = 0; d < dir.length; d++) {
			int nr = r, nc = c;
			for (int i = 0; i < val; i++) {
				nr = nr + dir[d][0];
				nc = nc + dir[d][1];
				if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
					if(map[nr][nc]>0) {
						int tp = map[nr][nc];
						around(nr,nc,tp-1);
					}
				}
			}
		}
	}

	private static void push() {
		for (int c = 0; c < W; c++) {
			List<Integer> list = new ArrayList<Integer>();
			for (int r = H-1; r >= 0; r--) {
				if(map[r][c]>0) list.add(map[r][c]);
			}
			for (int r = H-1; r >= 0; r--) {
				if((H-1)-r<list.size()) {
					map[r][c] = list.get((H-1)-r); 
				}else {
					map[r][c] = 0;
				}
			}
		}
	}

	private static void reinit(int[][] tmp) {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				int tp = tmp[r][c];
				map[r][c] = tp;
			}
		}
	}

	private static void init(int[][] tmp) {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				int tp = map[r][c];
				tmp[r][c] = tp;
			}
		}
	}
}
