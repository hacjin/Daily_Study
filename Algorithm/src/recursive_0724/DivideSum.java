package recursive_0724;

import java.util.Scanner;

public class DivideSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(n+"의 각 자릿수의 합 : " +sum(n));
		
	}
	public static int sum(int n) {
		if(n < 10) return n;
		return n%10 + sum(n/10);
	}
}
