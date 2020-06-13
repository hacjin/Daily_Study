package array_0724;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D4_1210_Ladder1_N_이학진 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int N = 100;
		int p = 0;
		int nr = 0, nc = 0;
		int data[][] = new int[N][N];
		int dir[][] = { { -1, 0 }, { 0, -1 }, { 0, 1 } }; // 상 좌 우
		int dis = 0;

		for (int t = 0; t < T; t++) {
			int T_count = sc.nextInt();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					data[i][j] = sc.nextInt();
				}
			}
//			===================== 입력 =======================
			for (int i = 0; i < N; i++) { // 도착 지점 을 출발점으로 설정
				if (data[N - 1][i] == 2) {
					nr = N - 1;
					nc = i;
				}
			}
			while (true) {

				if (nc + dir[2][1] < N && data[nr][nc + dir[2][1]] == 1 && dis != 1) { // 우측 여부 확인
					nr = nr + dir[2][0];
					nc = nc + dir[2][1];
					dis = 2;
				}
				if (nc + dir[1][1] >= 0 && data[nr][nc + dir[1][1]] == 1 && dis != 2) { // 좌측 여부 확인
					nr = nr + dir[1][0];
					nc = nc + dir[1][1];
					dis = 1;
				}
				if (data[nr + dir[0][0]][nc] == 1) {
					nr = nr + dir[0][0];
					nc = nc + dir[0][1];
					dis = 0;
				}
				if (nr == 0) {
					p = nc;
					break;
				}
			}
			System.out.println("#" + T_count + " " + p);
		}
	}
}
