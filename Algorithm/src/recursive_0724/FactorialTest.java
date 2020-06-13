package recursive_0724;

import java.util.Scanner;

public class FactorialTest {

	private static int result[];

	private static int factorial(int n) {
		if (n == 1)
			return 1;
		return factorial(n - 1) * n;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		result = new int[T];
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			System.out.println(result[i] = factorial(n));
		}

	}
}
