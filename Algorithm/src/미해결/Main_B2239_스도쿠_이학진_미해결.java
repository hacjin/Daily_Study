package 미해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B2239_스도쿠_이학진_미해결 {
	static int map[][]=new int[9][9];
	static int sub[][][] = new int[9][3][3];
	static boolean visit[];
	static int vcnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int index = 0;
		for (int r = 0; r < 9; r++) {
			String str = br.readLine();
			for (int c = 0; c < 9; c++) {
				int tmp = str.charAt(c)-'0';
				index = r/3*3 + c/3;
				sub[index][r%3][c%3] = tmp;
				map[r][c] = tmp;
			}
		}
		
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if(map[r][c] == 0) {
					index = r/3*3+c/3;
					vcnt = 9;
					visit  = new boolean[9];
					check(r,c,index);
					for (int i = 0; i < 9; i++) {
						if(!visit[i]) {
							map[r][c] = i+1;
							break;
						}
					}
				}
			}
		}
		
		for (int[] i : map) {
			for (int res : i) {
				System.out.print(res);
			}
			System.out.println();
		}
	}
	private static void check(int r, int c, int index) {
		for (int nr = 0; nr < 9; nr++) {		// 행검사
			if(map[nr][c]!=0)  {
				if(!visit[map[nr][c]-1]) vcnt--;
				visit[map[nr][c]-1] = true;
			}
		}
		
		for (int nc = 0; nc < 9; nc++) {		// 열검사
			if(map[r][nc]!=0) {
				if(!visit[map[r][nc]-1]) vcnt--;
				visit[map[r][nc]-1] = true;
			}
		}
		
		for (int nr = 0; nr < 3; nr++) {
			for (int nc = 0; nc < 3; nc++) {
				if(sub[index][nr][nc]!=0) {
					if(!visit[sub[index][nr][nc]-1]) vcnt--;
					visit[sub[index][nr][nc]-1] = true;
				}
			}
		}
	}
}
