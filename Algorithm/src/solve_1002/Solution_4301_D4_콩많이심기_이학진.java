package solve_1002;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4301_D4_콩많이심기_이학진 {
	static int dir[][] = {{0,2},{2,0},{0,-2},{-2,0}};
	static int map[][],C,R;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(map[r][c]!=1) {
						int nr,nc;
						for (int d = 0; d < dir.length; d++) {
							nr = r+dir[d][0];
							nc = c+dir[d][1];
							if(nr>=0 && nr< R && nc>=0 && nc< C) {
								map[nr][nc] =1;
							}
						}
					}
				}
			}
			
			int max =0;
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(map[r][c]==0) max++;
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}
}