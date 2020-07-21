package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * fibonacci(0) = 0 , fibonacci(1) = 1
 * 이후 호출되는 n에 대하여 0과 1을 출력 횟수를 출력하시오
 */
public class Main_B1003_피보나치함수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int input[] = new int[T];
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			input[t] = N;
		}
		for (int i = 0; i < T; i++) {
			int N = input[i];
			int memo[][] = new int[N+1][2];
			fibonacci(N,memo);
			System.out.println(memo[N][0] + " " + memo[N][1]);
		}
	}

	private static int[] fibonacci(int n, int[][] memo) {
		if(n==0) {
			memo[n][0] = 1;
			memo[n][1] = 0;
			return memo[n];
		}
		else if(n==1) {
			memo[n][1] = 1;
			memo[n][0] = 0;
			return memo[n];
		}else {
			if(memo[n][0] > 0 || memo[n][1] > 0) return memo[n];
			else {
				memo[n][0] = fibonacci(n-1,memo)[0] + fibonacci(n-2,memo)[0];
				memo[n][1] = fibonacci(n-1,memo)[1] + fibonacci(n-2,memo)[1];
				return memo[n];
			}
		}
	}
}
