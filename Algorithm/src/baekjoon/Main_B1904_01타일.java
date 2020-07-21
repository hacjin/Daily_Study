package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B1904_01타일 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int memo[] = new int[1000001];
		System.out.println(tile(N,memo));
	}
	private static int tile(int n,int[] memo) {
		memo[1] = 1;
		memo[2] = 2;
		if(n>2) {
			for (int i = 3; i < n+1; i++) {
				memo[i] = (memo[i-1] + memo[i-2])%15746;
			}
		}
		return memo[n];
	}
}
