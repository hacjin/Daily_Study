package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3985_롤케이크 {
	static int roll[], people[], cnt[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int L, N;
		L = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		roll = new int[L + 1];
		people = new int[N+1];
		cnt = new int[N+1];
		
		int s, e;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			people[i] = e - s + 1; // 해당 번호 방청객의 기대 량
			for (int j = s; j <= e; j++) {
				if (roll[j] == 0) {
					roll[j] = i;
					cnt[i]++; // 해당 번호 방청객의 실제 받는 케이크량
				}
			}
		}
		int real = 0, hope = 0;
		int rm = 0, hm = 0;
		for (int i = 1; i <= N; i++) {
			if (hm < people[i]) {
				hm = people[i];
				hope = i;
			} 
			if (rm < cnt[i]) {
				rm = cnt[i];
				real = i;
			}
		}
		System.out.println(hope);
		System.out.println(real);
	}
}
