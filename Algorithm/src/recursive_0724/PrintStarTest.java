package recursive_0724;

import java.util.Scanner;

public class PrintStarTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		printStar(n);
	}
	public static void printStar(int n) {
		if(n==0) return;
//		n-1개 직각삼각형 출력
		printStar(n-1);
//		n개 별 출력
		for (int i = 0; i < n; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
}
