package dp_0918;
import java.util.Scanner;

public class Apart {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int f[] = new int[N+1];
		
		f[1] = 2;
		f[2] = 3;
		for (int i = 3; i <= N; i++) {
			f[i] = f[i-1]+f[i-2];
		}
		System.out.println(f[N]);
	}
}
