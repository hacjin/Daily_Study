package dp2_0919;

import java.util.ArrayList;
import java.util.Scanner;

public class KnapsackTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int [] weights = new int[N+1];
		int [] profits = new int[N+1];
		int[][] D = new int[N+1][W+1];
		boolean[][] V = new boolean[N+1][W+1];
		
		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {	// 물건 1 부터 물건 N 까지 고려
			for (int j = 1; j <= W; j++) {	// 무게 1 부터 W까지 계산
				if(weights[i]<=j) {	// 포함이 가능한 상황
					// 포함 시도 , 미포함
//					D[i][j] = Math.max(D[i-1][j-weights[i]] + profits[i], D[i-1][j]);
					if(D[i-1][j-weights[i]] + profits[i]>D[i-1][j]) {
						D[i][j] = D[i-1][j-weights[i]] + profits[i];
						V[i][j] = true;	// 현 물건이 포함되었다고 체크
					}else {
						D[i][j] = D[i-1][j];
					}
				}else { // 미포함 : 포함이 불가능한 상황
					D[i][j] = D[i-1][j];
				}
			}
		}
		System.out.println(D[N][W]);
		int tmpN = N, tmpW = W;
		ArrayList<Integer> list = new ArrayList<Integer>();
		do {
			if(V[tmpN][tmpW]) {
				list.add(tmpN);
				tmpW -= weights[tmpN];
			}
			tmpN--;
		}while(tmpN>0);
		
		System.out.println(list.toString());
/*		StringBuilder str = new StringBuilder();
		for (int i = N,j = W; i > 0; i-- ) {
				if(V[i][j]) {
					str.append(i+" ");
					j = j-weights[i];
				}
		}
		System.out.println(str.toString());*/
	}
}
