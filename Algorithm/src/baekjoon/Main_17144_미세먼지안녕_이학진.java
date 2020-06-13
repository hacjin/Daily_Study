package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕_이학진 {
	static int dir[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // 동 서 남 북
	static int R, C, T;
	static int map[][], tmp[][];
	static int cleaner[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		tmp = new int[R][C];
		cleaner = new int[2][2];
		int i = 0;
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				int d = Integer.parseInt(st.nextToken());
				map[r][c] = d;
				tmp[r][c] = d;
				if (map[r][c] == -1) {
					cleaner[i][0] = r;
					cleaner[i++][1] = c;
				}
			}
		}
		for (int t = 0; t < T; t++) {
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[r][c] > 0 && map[r][c] != -1) {
						diffusion(r,c);
					}
				}
			}
			clean();
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					map[r][c] = tmp[r][c];
				}
			}
		}
		int res = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(tmp[r][c]!=-1)
				res += tmp[r][c];
			}
		}
		System.out.println(res);
	}

	private static void diffusion(int r,int c) {
		int count = 0, nr, nc;
		int dif_val = map[r][c] / 5;
		for (int i = 0; i < 4; i++) {
			nr = r + dir[i][0];
			nc = c + dir[i][1];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
				if (map[nr][nc] != -1) {
					count++;
					tmp[nr][nc] += dif_val;
				}
			}
		}
		tmp[r][c] -= dif_val * count;
	}

	private static void clean() {
		int cr = cleaner[0][0];
		int cc = cleaner[0][1];
		for (int r = cr - 1; r > 0; r--) {
			tmp[r][cc] = tmp[r - 1][cc];
		}
		for (int c = cc; c < C - 1; c++) {
			tmp[0][c] = tmp[0][c + 1];
		}
		for (int r = 0; r < cr; r++) {
			tmp[r][C - 1] = tmp[r + 1][C - 1];
		}
		for (int c = C - 1; c > cc; c--) {
			if (tmp[cr][c - 1] == -1) {
				tmp[cr][c] = 0;
			} else {
				tmp[cr][c] = tmp[cr][c - 1];
			}
		}

		cr = cleaner[1][0];
		cc = cleaner[1][1];
		for (int r = cr + 1; r < R - 1; r++) {
			tmp[r][cc] = tmp[r + 1][cc];
		}
		for (int c = cc; c < C - 1; c++) {
			tmp[R - 1][c] = tmp[R - 1][c + 1];
		}
		for (int r = R - 1; r > cr; r--) {
			tmp[r][C - 1] = tmp[r - 1][C - 1];
		}
		for (int c = C - 1; c > cc; c--) {
			if (tmp[cr][c - 1] == -1) {
				tmp[cr][c] = 0;
			} else {
				tmp[cr][c] = tmp[cr][c - 1];
			}
		}
	}
}
