package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_2806_NQueen_이학진_강사님 {
	static int N,ans=0;
	static boolean col[],slash[],bslash[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			ans=0;
			col = new boolean[N+1];
			slash = new boolean[N*2+1];
			bslash = new boolean[N*2+1];
			go(1);
			System.out.println("#"+t+" "+ans);
		}

	}

	private static void go(int row) {
		if(row == N+1) {
			ans++;
			return;
		}
		for (int c = 1; c <= N; c++) {
			if(!col[c] && !slash[row+c] && !bslash[row-c+N]) {
				col[c] = slash[row+c] = bslash[row-c+N] = true;
				go(row+1);
				col[c] = slash[row+c] = bslash[row-c+N] = false;
			}
		}
	}
}
