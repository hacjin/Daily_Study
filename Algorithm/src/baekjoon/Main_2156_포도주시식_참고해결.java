package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2156_포도주시식_참고해결 {
	static int grape[];
	static int dp[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		grape = new int[N+1];
		dp = new int[N+1];
		for (int n = 1; n <= N; n++) {
			grape[n] = Integer.parseInt(br.readLine());
		}
		if(N>0) {
			dp[1] = grape[1];
		}
		if(N>1) {
			dp[2] = dp[1] + grape[2];
		}
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-3] + grape[i-1] + grape[i], dp[i-2]+grape[i]);
			dp[i] = Math.max(dp[i], dp[i-1]);
		}
		System.out.println(dp[N]);
	}
}
