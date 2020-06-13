package stack_dfs_memoi_etc_0801;

import java.util.Scanner;

public class FibonacciTest {
	public static int fibonacci1(int n) {
		if (n <= 2)
			return 1;
		return fibonacci1(n - 2) + fibonacci1(n - 1);
	}

	private static int[] memo;

	public static int fibonacci2(int n) {

		if (n > 2 && memo[n] == 0) {
			memo[n] = fibonacci2(n - 2) + fibonacci2(n - 1);
		}
		return memo[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		memo = new int[n + 1]; // 0으로 자동초기화 : 0값 = > 메모안된 상태
		memo[1] = memo[2] = 1;
		System.out.println(fibonacci2(n));
		System.out.println(fibonacci1(n));
	}
}

