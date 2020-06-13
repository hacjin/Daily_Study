package recursive_0724;

import java.util.Scanner;

public class DigitSumTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(digitSum(n));
	}

	private static int digitSum(int n) {
		if(n<10) return n;
		 
		int current = n%10;
		int k = n/10;
		return digitSum(k)+current;
	}
}






