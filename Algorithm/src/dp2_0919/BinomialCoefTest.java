package dp2_0919;

import java.util.Scanner;

// 이항 계수 구하기 ( 파스칼 삼각형 ) 
public class BinomialCoefTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
//		int [][] D = new int[N+1][N+1];		end = i까지 구할 경우
		int [][] D = new int[N+1][K+1];
		
		// D[i][k] = D[i-1][k-1] + D[i-1][k];
		// D[i][k] = 1 인 경우 k==0 이거나 k==i
		
		for (int i = 0; i <= N; i++) {
			int end = i<K?i:K;
			for (int j = 0; j <= end; j++) {
				if(j==0 || j==i) D[i][j] = 1;
				else {
					D[i][j] = D[i-1][j-1] + D[i-1][j];
				}
			}
		}
		System.out.println(D[N][K]);
	}
}
