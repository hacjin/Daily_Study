package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N, M, cnt = 0;
		int map[][];
		int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 0 : 북 1:동 2:남 3:서
		int sr, sc, sd;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		sd = Integer.parseInt(st.nextToken());

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int nr, nc;
		boolean isFind = false;
		while (true) {
			if (map[sr][sc] == 0) {
				map[sr][sc] = 2;
				isFind = false;
				cnt++;
			}

			for (int d = 0; d < 4; d++) {	// 4방향 왼쪽 탐색
				if (sd == 0) {
					sd = 3;
				} else {
					sd = sd - 1;
				}
				nr = sr + dir[sd][0];
				nc = sc + dir[sd][1];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (map[nr][nc] == 0) {
						sr = nr;
						sc = nc;
						isFind = true;
						break;
					}
				}
			}
			if(!isFind) {
				sr = sr - dir[sd][0];
				sc = sc - dir[sd][1];
				if(map[sr][sc]==1) {
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
