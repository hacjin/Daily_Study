package recursive_0724;

import java.util.Scanner;

public class SumTest {

	private static int sum(int n) {
		if(n==1) return 1;
		return sum(n-1)+n;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(sum(n));
	}

}
