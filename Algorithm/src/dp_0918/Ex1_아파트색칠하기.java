package dp_0918;
import java.util.Scanner;

public class Ex1_아파트색칠하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int [][] D = new int[N+1][2];
		//D[i][0] = D[i-1][0] + D[i-1][1];		노랑색
		//D[i][1] = D[i-1][0];		파랑색
		
		D[1][0] = D[1][1] = 1;
		for (int i = 2; i <= N; i++) {
			D[i][0] = D[i-1][0] + D[i-1][1];
			D[i][1] = D[i-1][0];
		}
		System.out.println(D[N][0]+D[N][1]);
	}
}
