package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1149_RGB거리_이학진 {
	static int N;
	static int home[][];
	static int dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		home = new int[N][3];		// 색 값 저장
		dp = new int[N][3];
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 3; c++) {
				home[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0]=home[0][0]; dp[0][1]=home[0][1]; dp[0][2]=home[0][2];
		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + home[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + home[i][1];
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + home[i][2];
		}
		System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
	}
}
