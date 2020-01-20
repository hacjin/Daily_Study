package dp_0918;
import java.util.Scanner;

public class MinCoinTest3_DP2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int D[][] = new int[money+1][3];
		
		for (int i = 1; i <= money; i++) {
			int min =Integer.MAX_VALUE;
			for (int j = 0; j < 3; j++) {
				if(i>=1) {
					if(j==0 && D[i-1][j]+1<min) min=D[i-1][j]+1;
				}
				if(i>=4) {
					if(j==1 && D[i-4][j]+1<min) min=D[i-4][j]+1;
				}
				if(i>=6) {
					if(j==2 && D[i-6][j]+1<min) min=D[i-6][j]+1;
				}
				D[i][j]=min;
			}
		}
		System.out.println(D[money][2]);
	}
}
