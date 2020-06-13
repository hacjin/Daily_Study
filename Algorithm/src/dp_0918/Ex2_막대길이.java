package dp_0918;
import java.util.Scanner;

public class Ex2_막대길이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int f[] = new int[N+1];
		f[1] = 2;
		f[2] = 5;
		for (int i = 3; i <= N; i++) {
			f[N] = f[N-1]*2 + f[N-2];
		}
		System.out.println(f[N]);
	}
}
