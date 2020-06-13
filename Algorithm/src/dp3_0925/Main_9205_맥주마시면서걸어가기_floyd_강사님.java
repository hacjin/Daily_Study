package dp3_0925;

import java.util.Scanner;

public class Main_9205_맥주마시면서걸어가기_floyd_강사님 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] location = new int[N + 2][2];
			for (int i = 0; i < N; i++) {
				location[i][0] = sc.nextInt();
				location[i][1] = sc.nextInt();
			}

			boolean[][] D = new boolean[N + 2][N + 2];
			for (int i = 0; i < N; i++) { // 인접행렬 만들기
				for (int j = i + 1; j < N; j++) {
					int chk = Math.abs(location[i][0] - location[j][0]) + Math.abs(location[i][1] - location[j][1]);
					if (chk <= 1000) {
						D[i][j] = D[j][i] = true;
					}
				}
			}
			for (int k = 0; k < N; k++) { // 경유지
				for (int i = 0; i < N; i++) { // 출발지
					for (int j = 0; j < N; j++) { // 도착지
						if (!D[i][j] && D[i][k] && D[k][j]) {
							D[i][j] = true;
						}
					}
				}
			}
			System.out.println(D[0][N + 1] ? "happy" : "sad");
		}
		sc.close();
	}
}
