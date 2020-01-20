package 미해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12100_2048_미해결 {
	static int move = 0;
	public static void main(String[] args) throws IOException {
		int N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int number;
		int data[][] = new int[N][N];
		int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상 하 좌 우
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				number = Integer.parseInt(st.nextToken());
				if (number % 2 != 0) {
					i--;
					break;
				}
				data[i][j] = number;
			}
		}

		int nr=0, nc=0,rr=0,rc=0;
		for (int i = 0; i < N; i++) {
			if(move==5) break;
			for (int j = 0; j < N; j++) {
				if (data[i][j] == 0) {
					for (int k = 0; k < 4; k++) {
						nr = i + dir[k][0];
						nc = j + dir[k][1];
						if (nr >= 0 && nr < N && nc >= 0 && nc < N && data[nr][nc] != 0) {
							i = nr;
							j = nc;
						}
					}
					continue;
				}
				for (int k = 0; k < 4; k++) {
					nr = i + dir[k][0];
					nc = j + dir[k][1];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && data[nr][nc] != 0) {
						if (data[i][j] == data[nr][nc]) {
							data[nr][nc] = data[i][j] * 2;
							data[i][j] = 0;
							rr = nr; rc=nc;
							move++;
						}
					}
				}
			}
		}
		System.out.println(data[rr][rc]);

	}
}
