package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1127_맛있는음식 {
	static int MAX_COUNT;
	static int N, idx;
	static int resS[][], resB[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int S[], B[];
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		MAX_COUNT = (int) Math.pow(2, N) - 1;
		resS = new int[N][MAX_COUNT];
		resB = new int[N][MAX_COUNT];
		for (int[] i : resS) {
			Arrays.fill(i, -1);
		}
		for (int[] i : resB) {
			Arrays.fill(i, -1);
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		idx = 0;
		multi(S, 0, 1, 0);
		idx = 0;
		sum(B, 0, 0, 0);

		int res = 1000000000;
		int min;
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < MAX_COUNT; i++) { // N이 10인 경우 1023 번 최대 1000만번의 경우 1초이내 가능
				if (resS[k][i] != -1 && resB[k][i] != -1) {
					min = Math.abs(resS[k][i] - resB[k][i]);
					if (res > min) {
						res = min;
					}
				}
			}
		}
		System.out.println(res);
	}

	public static void multi(int arr[], int index, int num, int cnt) { // 선택지가 될 배열 S or B와 선택의 위치인 인덱스, 곱하거나 더해질 숫자가
																		// 들어와야 될것
		if (index == N) {
			if (idx < MAX_COUNT) {
				resS[cnt - 1][idx++] = num;
			}
			return;
		}

		multi(arr, index + 1, num * arr[index], cnt + 1);
		multi(arr, index + 1, num, cnt);
	}

	public static void sum(int arr[], int index, int num, int cnt) { // 선택지가 될 배열 S or B와 선택의 위치인 인덱스, 곱하거나 더해질 숫자가 들어와야
																		// 될것

		if (index == N) {
			if (idx < MAX_COUNT) {
				resB[cnt - 1][idx++] = num;
			}
			return;
		}
		sum(arr, index + 1, num + arr[index], cnt + 1);
		sum(arr, index + 1, num, cnt);

	}
}
