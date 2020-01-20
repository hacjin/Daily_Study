package stack_dfs_memoi_etc_0801;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(n + "번째 피보나치 값 : " + fibonachi(n));
		System.out.println(n + "번째 피보나치 값 : " + fibonachi(n,0,1));
	}

	public static int fibonachi(int n) { // n부터 ~1까지 하향식
		if (n == 1 || n == 2)
			return 1;
		return (fibonachi(n - 2) + fibonachi(n - 1));
	}

//	현재항 기준으로 다음항을 구하는법
	public static int fibonachi(int count,int before,int current) { // 1부터 n까지 상향식
		
		if (count == 1)
			return current;
		return fibonachi(--count, current, before+current);
		
	}
	/**
	 * 중복호출의 단점이 있다. 결과 => 메모이제이션(캐싱: cache)을 활용.
	 */
}
