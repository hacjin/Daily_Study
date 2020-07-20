package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B10870_피보나치 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(fibonachi(n));
	}

	private static int fibonachi(int n) {
		if(n==0) return 0;
		else if(n==1) return 1;
		else return fibonachi(n-1) + fibonachi(n-2);
	}
}
