package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * 백트래킹을 활용할 것 !! 이중 for문으로 구성시 시간초과 신경쓸것
 */
public class Main_18430_무기공학 {
	static int dir[][][] = { { { 0, -1 }, { 1, 0 } } // 좌,하
			, { { -1, 0 }, { 0, -1 } } // 상,좌
			, { { -1, 0 }, { 0, 1 } } // 상,우
			, { { 0, 1 }, { 1, 0 } } }; // 우,하
	static int N, M, max;
	static int map[][];
	static boolean visit[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if (N < 2 || M < 2)
			System.out.println(0);
		else {
			find(0, 0, 0);
			System.out.println(max);
		}
	}

	private static void find(int i, int j, int sum) {
		if (j == M) {
			j = 0;
			i++;
		}
		if (i == N) {
			max = Math.max(max, sum);
			return;
		}
		if (!visit[i][j]) {
			for (int k = 0; k < dir.length; k++) {
				ArrayList<int[]> tmp = new ArrayList<>();
				for (int l = 0; l < dir[k].length; l++) {
					int nr = i + dir[k][l][0];
					int nc = j + dir[k][l][1];
					if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visit[nr][nc]) {
						tmp.add(new int[] { nr, nc });
					}
				}
				if (tmp.size() > 1) {
					visit[i][j] = true;
					int nsum = 0;
					nsum += map[i][j] * 2;
					for (int l = 0; l < tmp.size(); l++) {
						int[] cur = tmp.get(l);
						visit[cur[0]][cur[1]] = true;
						nsum += map[cur[0]][cur[1]];
					}
					find(i, j + 1, sum + nsum);
					visit[i][j] = false;
					for (int l = 0; l < tmp.size(); l++) {
						int[] cur = tmp.get(l);
						visit[cur[0]][cur[1]] = false;
					}
				}
			}
		}
		find(i,j+1,sum);
	}
}
