package array_0718;

import java.util.Scanner;

public class Solution_D3_5431_민석이의과제체크하기_이학진 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, T, K, T_count;
		int H[];
		int tmp[];
		T = sc.nextInt();
		T_count = 0;
		while (T_count < T) {
			N = sc.nextInt();
			K = sc.nextInt();
			H = new int[K];
			tmp = new int[N];
			System.out.printf("#"+(++T_count)+" ");
			for (int i = 0; i < K; i++) {
				H[i] = sc.nextInt();
				tmp[H[i]-1]++;
			}
			for (int i = 0; i < N; i++) {
				if (tmp[i] == 0) {
					System.out.printf("%d ",i+1);
				}
			}
			System.out.println();
		}
	}
}
