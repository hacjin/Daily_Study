package 미해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5644_무선충전_미해결 {
	static int N = 10, M = 10;
	static int map[][];
	static int min_map[][];
	static int max_map[][];
	static int A[],B[],AP[][];
	static boolean visit[][];
	static int dir[][] = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			min_map = new int[N][M];
			max_map = new int[N][M];
			map = new int[N][M];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int bccnt = Integer.parseInt(st.nextToken());
			AP = new int[bccnt][4];
			A = new int[time];
			visit = new boolean[N][M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < time; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			B = new int[time];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < time; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < bccnt; i++) {
				st = new StringTokenizer(br.readLine());
				AP[i][0] = Integer.parseInt(st.nextToken());
				AP[i][1] = Integer.parseInt(st.nextToken());
				AP[i][2] = Integer.parseInt(st.nextToken());
				AP[i][3] = Integer.parseInt(st.nextToken());
			}
			
			mark(bccnt);
			System.out.println();
			int result = move(time,bccnt);
			System.out.println("#"+t+" "+result);
		}
	}
	private static int move(int size, int mod) {
		int ar = 0, ac = 0 , br=N-1, bc= M-1;
		int aval = min_map[ar][ac]>max_map[ar][ac]?min_map[ar][ac]:max_map[ar][ac];
		int bval = min_map[br][bc]>max_map[br][bc]?min_map[br][bc]:max_map[br][bc];
		for (int i = 0; i < size; i++) {
			int ad = A[i];
			int bd = B[i];
			
			ar += dir[ad][0];
			ac += dir[ad][1];
			br += dir[bd][0];
			bc += dir[bd][1];
			
			if(visit[ar][ac]) {
				if((map[ar][ac]%mod) == map[br][bc] && (map[br][bc]!=0 || map[br][bc]==mod) ) {
					aval += min_map[ar][ac];
					bval += max_map[br][bc];
				}else {
					if(map[ar][ac] == map[br][bc]) {
						bval += max_map[br][bc]/2;
						aval += max_map[ar][ac]/2;
					}else {
						aval += max_map[ar][ac];
						bval += max_map[br][bc];
					}
				}
			}else {
				if(visit[br][bc]) {
					if((map[br][bc]%mod)== map[ar][ac] && ( map[ar][ac]!=0 || map[ar][ac] == mod) ) {
						bval += min_map[br][bc];
						aval += max_map[ar][ac];
					}else {
						bval += max_map[br][bc];
						aval += max_map[ar][ac];
					}
				}else {
					if(map[ar][ac] == map[br][bc]) {
						bval += max_map[br][bc]/2;
						aval += max_map[ar][ac]/2;
					}else {
						bval += max_map[br][bc];
						aval += max_map[ar][ac];
					}
				}
			}
		}
		return aval+bval;
	}
	private static void mark(int size) {
		int x, y, r, v;
		for (int i = 0; i < size; i++) {
			x = AP[i][0]-1;
			y = AP[i][1]-1;
			r = AP[i][2];
			v = AP[i][3];
			int rmax = x+r>N-1?N-1:x+r; 
			int cmax = y+r>M-1?M-1:y+r; 
			int rmin = x-r<0?0:x-r; 
			int cmin = y-r<0?0:y-r; 
			for (int j = rmin; j <= rmax; j++) {
				for (int k = cmin; k <= cmax; k++) {
					int D = Math.abs(j-x) + Math.abs(k-y);
					if(D <= r) {
						if(map[k][j]==0) map[k][j] = i+1;
						else {
							visit[k][j] = true;
							map[k][j] += i+1;
						}
						if( max_map[k][j] <= v ) {
							int tmp = max_map[k][j];
							if(max_map[k][j] > 0) min_map[k][j] = tmp;
							max_map[k][j] = v;
						}
						else {
							if( min_map[k][j] < v ) min_map[k][j] = v;
						}
					}
				}
			}
		}
		
	}
}
