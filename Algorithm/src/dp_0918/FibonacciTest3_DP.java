package dp_0918;
import java.util.Scanner;

public class FibonacciTest3_DP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] result = new long[N+1];
		// result[i]= result[i-1]+result[i-2]
		result[0] = 0;
		result[1] = 1;
		for (int i = 2; i <= N; i++) {
			result[i] = result[i-1]+result[i-2];
		}
		System.out.println(result[N]);
	}
}
