package dp2_0919;

import java.util.Scanner;

public class Solution_D3_3307_최장증가부분수열_이학진 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[];
		int D[];
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int result=0;
			arr = new int[N];
			D = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			for (int i = 0; i < N; i++) {
				D[i]=1;
				for (int j = 0; j < i; j++) {
					if(arr[i]>arr[j]) {
						if(D[i]<D[j]+1) {
							D[i] = D[j]+1;
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				if(result<D[i]) result=D[i];
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
