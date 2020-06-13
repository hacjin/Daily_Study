package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12100_2048_2 {
	static int move = 0;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int number, max = 0, dis = 1;
		int data[][] = new int[N][N];
		int count = 0, tmp = 0;
		boolean chk = false;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				number = Integer.parseInt(st.nextToken());
				if (number % 2 != 0) {
					i--;
					break;
				}
				data[i][j] = number;
			}
		}
//	============입력=============
		while (true) {
			if (move == 5 || count == 4) {
				break;
			}
			if (dis == 5) {
				dis = 1;
				count = 0;
			}
			switch (dis) { // dis 1 : 우 2: 좌 3:상 4:하
			case 1:
				for (int i = 0; i < N; i++) {
					for (int j = N - 1; j > 0; j--) {
						if (data[i][j] != 0 && data[i][j] == data[i][j - 1]) {
							data[i][j] *= 2;
							for (int k = 0; k < j - 1; k++) {
								data[i][k + 1] = data[i][k];
								data[i][k] = 0;
								chk = true;
								move++;
							}
							break;
						} else {
							if (j == 1) {
								tmp = data[i][N - 1];
								if (tmp == 0) {
									for (int k = N - 1; k >= 0; k--) {
										data[i][k] = data[i][k - 1];
									}
									chk = false;
								}
							}
						}
					}
				}
				if (!chk)
					count++;
				dis++;
			case 2:
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N - 1; j++) {
						if (data[i][j] != 0 && data[i][j] == data[i][j + 1]) {
							data[i][j] *= 2;
							for (int k = N - 1; k > j + 1; k--) {
								data[i][k - 1] = data[i][k];
								data[i][k] = 0;
								chk = true;
								move++;
							}
							break;
						} else {
							if (j == N - 2) {
								tmp = data[i][0];
								if (tmp == 0) {
									for (int k = 0; k <= N - 1; k++) {
										if (k == N - 1) {
											data[i][k] = tmp;
										} else {
											data[i][k] = data[i][k + 1];
										}
									}
									chk = false;
								}
							}
						}
					}
				}
				if (!chk)
					count++;
				dis++;
			case 3:
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N - 1; j++) {
						if (data[j][i] != 0 && data[j][i] == data[j + 1][i]) {
							data[j][i] *= 2;
							for (int k = N - 1; k > j + 1; k--) {
								data[k - 1][i] = data[k][i];
								data[k][i] = 0;
								chk = true;
								move++;
							}
							break;
						} else {
							if (j == N - 2) {
								tmp = data[0][i];
								if (tmp == 0) {
									for (int k = 0; k >= N - 1; k++) {
										if (k == N - 1) {
											data[k][i] = tmp;
										} else {
											data[k][i] = data[k + 1][i];
										}
									}
									chk = false;
								}
							}
						}
					}
				}
				if (!chk)
					count++;
				dis++;
			case 4:
				for (int i = 0; i < N; i++) {
					for (int j = N - 1; j > 0; j--) {
						if (data[j][i] != 0 && data[j][i] == data[j - 1][i]) {
							data[j][i] *= 2;
							for (int k = 0; k < j - 1; k++) {
								data[k + 1][i] = data[k][i];
								data[k][i] = 0;
								chk = true;
								move++;
							}
							break;
						} else {
							if (j == 1) {
								tmp = data[N - 1][i];
								if (tmp == 0) {
									for (int k = N - 1; k >= 0; k--) {
										if (k == 0) {
											data[k][i] = tmp;
										} else {
											data[k][i] = data[k - 1][i];
										}

									}
									chk = false;
								}
							}
						}
					}
				}
				if (!chk)
					count++;
			}
		}

//	===========출력 ===============		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (data[i][j] > max) {
					max = data[i][j];
				}
			}
		}
		System.out.println(max);
	}

}
