package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1103_경비원 {
	static int call[][];
	static int sum[];
	static int R, C, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int me[], res = 0;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());

		call = new int[N][2]; // N은 상점의 번호 0은 방향 1은 위치.
		sum = new int[N];
		// 방향이 1 : 북 (행이 C) 2 : 남 (행이 0) 3 : 서 (열이 0) 4 : 동 (열이 R)
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				call[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		me = new int[2];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2; i++) {
			me[i] = Integer.parseInt(st.nextToken());
		}

		calc(me[0], 0, me[1]);
		for (int i = 0; i < N; i++) {
			res += sum[i];
		}
		System.out.println(res);
	}

	// 나의 방향을 기준으로 상점의 방향을 파악하여 거리 계산
	private static void calc(int dir, int index, int val) {
		int hap=0;
		if (index == N)
			return;
		if (dir % 2 == 1) { // dir = 1, 3
			if(dir == 1 ) hap= C; else hap=R;
			if (dir - call[index][0] == -1) {
				int tmp = (hap==C?R:C);
				if (val < tmp / 2 && call[index][1] < tmp / 2) {
					sum[index] = val + call[index][1] + hap;
				} else {
					sum[index] = Math.abs(tmp- val) + Math.abs(tmp - call[index][1]) + hap;
				}
			} else if (dir == call[index][0]) {
				sum[index] = Math.abs(val - call[index][1]);
			} else {
				if (call[index][0] < dir) {
					if (call[index][0] % 2 == 0) // 3이고 2일떄
					{
						sum[index] = Math.abs(C-val) + call[index][1];
					} else {
						sum[index] = val + call[index][1]; // 3이고 1일때
					}
				} else {
					if (call[index][0] % 2 == 0) //  1이고 4일때
					{
						sum[index] = Math.abs(R - val) + call[index][1]; 
					} else {
						sum[index] = val + call[index][1]; // 1이고 3일때
					}
				}
			}
		} else { // dir = 2, 4
			if( dir == 2 ) hap= C; else hap=R;
			if (dir - call[index][0] == 1) {		// 맞은편
				int tmp = (hap==C?R:C);
				if (val < tmp / 2 && call[index][1] < tmp / 2) {
					sum[index] = val + call[index][1] + hap;
				} else {
					sum[index] = Math.abs(tmp - val) + Math.abs(tmp - call[index][1]) + hap;
				}
			} else if (dir == call[index][0]) {		// 같은 행 또는 열 일 때
				sum[index] = Math.abs(val - call[index][1]);
			} else {		// 좌 또는 우 
				if (call[index][0] > dir) {
					if (call[index][0] % 2 == 1) // 2이고 3일때
					{
						sum[index] = val + Math.abs(C-call[index][1]);
					} else {
						sum[index] = Math.abs(R - val) + Math.abs(C-call[index][1]); // 2 이고 4일때
					}
				} else {
					if (call[index][0] % 2 == 1) // 4이고 1일때
					{
						sum[index] = val + Math.abs(R - call[index][1]);
					} else {
						sum[index] = Math.abs(C-val) + Math.abs(R - call[index][1]); // 4이고 2일때
					}
				}
			}
		}
		calc(dir, index + 1, val);
	}
}
