package dp_0918;
import java.util.Scanner;

public class FibonacciTest1_Recur {
	static long[] call;
	static long callSum;	// 모든 함수의 호출 갯수
	
	static long fibo(int n) {
		++call[n];
		++callSum;
		if(n<2) return n;
		return fibo(n-2) +fibo(n-1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		call = new long[N+1];	// count 목적 배열  피보나치 함수의 호출의 갯수를 위한
		System.out.println(fibo(N));
		for (int i = 0; i <= N; i++) {
			System.out.println("fibo("+i+") : "+call[i]);
		}
		System.out.println(callSum);
	}
}
