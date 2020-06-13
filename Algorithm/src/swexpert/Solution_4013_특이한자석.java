package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {
	static int mag[][] = new int[4][8];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < 8; j++) {
					mag[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int k = 0; k < K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int index = Integer.parseInt(st.nextToken());	// 회전시킬 자석 번호
				int rdir = Integer.parseInt(st.nextToken());	// 회전시킬 방향\
				check(index,rdir);
			}
			int sum = 0;
			for (int i = 0; i < mag.length; i++) {
				if(mag[i][0]==1) sum+= (int)Math.pow(2, i);
			}
			System.out.println("#"+t+" "+sum);
		}
	}
	private static void check(int index, int rdir) {
		int s = index - 1;
		int ro[] = new int[4];
		ro[s] = rdir;
		// 우측 확인 2인덱스와 6과 비교
		for (int i = s ; i < mag.length-1; i++) {
			if(mag[i][2] != mag[i+1][6]) ro[i+1] = ro[i]*-1;
		}
		// 좌측 확인 6과 2인덱스 비교
		for (int i = s; i > 0 ; i--) {
			if(mag[i][6] != mag[i-1][2]) ro[i-1] = ro[i]*-1;
		}
		for (int i = 0; i < ro.length; i++) {
			rotate(ro[i],i);
		}
	}
	private static void rotate(int val, int index) {
		int size = mag[index].length;
		if(val==1) {
			int tmp = mag[index][size-1];
			for (int i = size-1; i >0 ; i--) {
				mag[index][i] = mag[index][i-1];
			}
			mag[index][0] = tmp;
		}else if(val==-1) {
			int tmp = mag[index][0];
			for (int i = 0; i < size-1; i++) {
				mag[index][i] = mag[index][i+1];
			}
			mag[index][size-1] = tmp;
		}
	}
}
