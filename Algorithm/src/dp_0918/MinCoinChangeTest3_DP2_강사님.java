package dp_0918;
import java.util.Scanner;

public class MinCoinChangeTest3_DP2_강사님 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int D[][] = new int[3][money+1];
		int[] coin = {1,4,6};
		
		for (int j = 1; j <= money; j++) {
			if(j%coin[0]==0) D[0][j] = j/coin[0];
		}
		for (int i = 1; i <= money; i++) {
			int min =Integer.MAX_VALUE;
			for (int j = 0; j < 3; j++) {
				if(j<1) {
					D[i][j] = D[i-coin[j]][j]+1;
					continue;
				}
				if(i-coin[j]<0) {
					D[i][j] = D[i][j-1];
					continue;
				}
				D[i][j] = Math.min(D[i-coin[j]][j]+1, D[i][j-1]);
			}
		}
		System.out.println(D[money][2]);
	}
}
