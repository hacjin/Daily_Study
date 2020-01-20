package permu_combi_bitOper_etc_0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1240_D3_단순2진암호코드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T, N, M, sum;
		String map[];
		String num[] = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
				"0110111", "0001011" };
		int pass[], match[];
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new String[N];
			pass = new int[8];
			match = new int[8];
			sum = 0;

			for (int n = 0; n < N; n++) {
				map[n] = br.readLine();
			}

			// nr 과 nc는 암호코드가 존재하고 시작되는 행,열을 저장
			int nr = 0, nc = 0;
			for (int n = 0; n < N; n++) {
				if(nc!=0) break;
				for (int m = 0; m < M - 7; m++) {
					if(nc!=0) break;
					if (map[n].charAt(m) == '0' && map[n].charAt(m + 6) == '1') {
						for (int i = 0; i < num.length; i++) {
							if (map[n].substring(m, m + 7).equals(num[i])) {
								if(map[n].charAt(m+7)=='0') {
									nr = n;
									nc = m;
									break;
								}
							}
						}
						
					}
				}
			}
			int idx = 0, odd = 0, even = 0, code = 0;
			int n = nr;
			for (int c = nc; c < M - 7; c += 7) {
				for (int i = 0; i < num.length; i++) {
					if (map[n].substring(c, c + 7).equals(num[i])) {
						pass[idx++] = i;
					}
				}
			}
			match = Arrays.copyOf(pass, 8);
			for (int i = 0; i < pass.length; i++) {
				if (i % 2 == 0) {
					odd += pass[i];
				} else {
					even += pass[i];
				}
			}
			odd *= 3;
			if((odd+even)%10!=0) {
				code = 10 - ((odd + even) % 10);
				match[7] = code;
			}
			if (Arrays.equals(pass, match)) {
				for (int i : match) {
					sum += i;
				}
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}
