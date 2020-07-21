package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B2748_피보나치2 {
	static long memo[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memo = new long[100];
		System.out.println(fibonachi(N));
	}

	private static long fibonachi(int n) {
		if(n<2) return memo[n] = n;
		if(memo[n]>0) return memo[n];
		return memo[n] = fibonachi(n-1) + fibonachi(n-2);
	}
}
