package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main_13458_시험감독 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		long min = 0, subcount = 0, maincount = 0;
		int N, B, C;
		int A[];

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());

		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			int remain = A[i]-B;
			if (remain == 0 || remain < 0 ) {
				maincount += 1;
			} else {
				maincount++;
				subcount = (remain) / C;
				if ((remain)%C != 0 && (remain)%C < C) {
					subcount = subcount + 1;
				}
				min += subcount;
			}
		}
		min = min + maincount;
		System.out.println(min);
	}
}
