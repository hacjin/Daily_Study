package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6109_추억의2048게임_이학진 {
	static int N;
	static int map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String dir;
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			dir = st.nextToken();
			map = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			move(dir);
			System.out.println("#"+t);
			for (int out[] : map) {
				for (int o : out) {
					System.out.print(o+" ");
				}
				System.out.println();
			}
		}
	}
	private static void move(String dir) {
		if(dir.equals("up")) { 
			for (int r = 0; r < N-1; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c]!=0) {
						int nr = r+1;
						if(nr!=N-1 && map[nr][c]==0) {
							while(map[nr][c]==0) {
								if(nr==N-1) break;
								nr++;
							}
						}
						if(map[r][c]==map[nr][c]) {
							map[r][c] = map[r][c]+map[nr][c];
							map[nr][c] = 0;
						}
					}
				}
			}
			swap(0);
		}
		else if(dir.equals("down")) { 
			for (int r = N-1; r > 0; r--) {
				for (int c = 0; c < N; c++) {
					if(map[r][c]!=0) {
						int nr = r-1;
						if(nr!=0 && map[nr][c]==0) {
							while(map[nr][c]==0) {
								if(nr==0) break;
								nr--;
							}
						}
						if(map[r][c]==map[nr][c]) {
							map[r][c] = map[r][c]+map[nr][c];
							map[nr][c] = 0;
						}
					}
				}
			}
			swap(1);
		}
		else if(dir.equals("right")) { 
			for (int c = N-1; c > 0; c--) {
				for (int r = 0; r < N; r++) {
					if(map[r][c]!=0) {
						int nc = c-1;
						if(nc!=0 && map[r][nc]==0) {
							while(map[r][nc]==0) {
								if(nc==0) break;
								nc--;
							}
						}
						if(map[r][c]==map[r][nc]) {
							map[r][c] = map[r][c]+map[r][nc];
							map[r][nc] = 0;
						}
					}
				}
			}
			swap(2);
		}
//		if(dir.equals("left")) 
		else{ 
			for (int c = 0; c < N-1; c++) {
				for (int r = 0; r < N; r++) {
					if(map[r][c]!=0) {
						int nc = c+1;
						if(nc!=N-1 && map[r][nc]==0) {
							while(map[r][nc]==0) {
								if(nc==N-1) break;
								nc++;
							}
						}
						if(map[r][c]==map[r][nc]) {
							map[r][c] = map[r][c]+map[r][nc];
							map[r][nc] = 0;
						}
					}
				}
			}
			swap(3);
		}
	}
	private static void swap(int d) {
		switch(d) {
		case 0: // up
			for (int c = 0; c < N; c++) {
				for (int r = N-2; r >= 0; r--) {
					if(map[r][c]==0) {
						for (int i = r+1; i < N; i++) {
							map[i-1][c] = map[i][c];
						}
						map[N-1][c] = 0;
					}
				}
			}
			break;
		case 1: //down
			for (int c = 0; c < N; c++) {
				for (int r = 1; r < N; r++) {
					if(map[r][c]==0) {
						for (int i = r-1; i >= 0; i--) {
							map[i+1][c] = map[i][c];
						}
						map[0][c] = 0;
					}
				}
			}
			break;
		case 2: // right
			for (int r = 0; r < N; r++) {
				for (int c = 1; c < N; c++) {
					if(map[r][c]==0) {
						for (int i = c-1; i >= 0; i--) {
							map[r][i+1] = map[r][i];
						}
						map[r][0] = 0;
					}
				}
			}
			break;
		case 3: // left
			for (int r = 0; r < N; r++) {
				for (int c = N-2; c >= 0; c--) {
					if(map[r][c]==0) {
						for (int i = c+1; i < N; i++) {
							map[r][i-1] = map[r][i];
						}
						map[r][N-1] = 0;
					}
				}
			}
			break;
		}
	}
}