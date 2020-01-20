package jungol;

import java.util.Scanner;

public class Main_별삼각형1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m;

		n = sc.nextInt();
		m = sc.nextInt();
		if (n > 100 || n < 0) {
			System.out.println("INPUT ERROR!");
		} else {
			switch (m) {
			case 1:
				for (int i = 0; i < n; i++) {
					for (int j = 0; j <= i; j++) {
						System.out.printf("*");
					}
					System.out.println();
				}
				break;
			case 2:
				for (int i = 0; i < n; i++) {
					for (int j = n; j > i; j--) {
						System.out.printf("*");
					}
					System.out.println();
				}
				break;
			case 3:
				for (int i = 1; i <= n; i++) {
					for (int j = 0; j < n-i; j++) {
						System.out.printf(" ");
					}
					for (int j = 0; j < i*2-1; j++) {
						System.out.printf("*");
					}
					System.out.println();
				}
				break;
				default:
					System.out.println("INPUT ERROR!");
					break;
			}
		}
	}
}
