package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_2806_NQueen_이학진 {
	static int N,res=0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean chk[][];
		N = Integer.parseInt(br.readLine());
		chk = new boolean[N][N];

		qeen(0, 0, chk);
		System.out.println(res);
	}

	private static void qeen( int r, int c, boolean[][] chk) {
		if(r==N ) {res++; return;}
		if(c==N) {return;}
		int find = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j <= c; j++) {
				if(i==r&&chk[i][j]) { find = 1; break; }
				if(j==c&&chk[i][j]) { find = 2; break; }
				if(i-j == r-c &&chk[i][j]) { find =3; break; }
			}
		}
		if(find!=0) {
			qeen(r,c+1,chk);
		}
		else {
			chk[r][c]=true;
			qeen(r+1,c,chk);
			chk[r][c]=false;
			qeen(r,c+1,chk);
		}
	}
}
