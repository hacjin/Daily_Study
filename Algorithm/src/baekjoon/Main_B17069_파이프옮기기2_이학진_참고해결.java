package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B17069_파이프옮기기2_이학진_참고해결 {
	static int N, map[][];
	static long dp[][][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new long[3][N][N];
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0][1] = 1;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(c+1<N && map[r][c+1]==0) dp[0][r][c+1] += dp[0][r][c] + dp[2][r][c];
				if(r+1<N && map[r+1][c]==0) dp[1][r+1][c] += dp[1][r][c] + dp[2][r][c];
				if(r+1<N && c+1<N && map[r+1][c+1]==0 && map[r][c+1]==0 && map[r+1][c]==0) {
					dp[2][r+1][c+1] += dp[0][r][c] + dp[1][r][c] + dp[2][r][c]; 
				}
			}
		}
		System.out.println(dp[0][N-1][N-1]+dp[1][N-1][N-1]+dp[2][N-1][N-1]);
	}
}
