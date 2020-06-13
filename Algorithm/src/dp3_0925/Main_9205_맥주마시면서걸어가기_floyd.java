package dp3_0925;

import java.util.Scanner;

public class Main_9205_맥주마시면서걸어가기_floyd {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		int[][] node;
		int[][] D;
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int N = n+2;
			node = new int [N][2];
			D = new int[N][N];
			for (int i = 0; i < N; i++) {
				node[i][0] = sc.nextInt();
				node[i][1] = sc.nextInt();
			}
			
			for (int i = 0; i < N; i++) {	// 인접행렬 만들기
				for (int j = 0; j < N; j++) {
					if(i==j) D[i][j] = 0;
					else {
						int chk = Math.abs(node[i][0]-node[j][0]) +Math.abs(node[i][1]-node[j][1]);
						if(chk <= 1000) {
							D[i][j] = 1;
						}
					}
				}
			}
			for (int k = 0; k < N; k++) {	// 경유지
				for (int i = 0; i < N; i++) {	// 출발지
					if(i==k) continue;
					for (int j = 0; j < N; j++) {	// 도착지
						if(j==k || i==j) continue;
						if( D[i][k]==1 && D[k][j]==1) {
							D[i][j] = 1;
						}
					}
				}
			}
			if(D[0][N-1]==1) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
		}
		sc.close();
	}
}
