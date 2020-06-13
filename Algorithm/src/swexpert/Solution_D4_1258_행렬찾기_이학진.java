package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D4_1258_행렬찾기_이학진 {
	static boolean visit[][];
	static int dir[][] = {{0,1},{1,0}};	// 동 ,남
	static int map[][];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			List<Integer[]> list = new ArrayList<Integer[]>();
			map = new int[N][N];
			visit = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c]>0 && !visit[r][c]) {
						search(r,c,list);
					}
				}
			}
			Collections.sort(list, new Comparator<Integer[]>() {
				@Override
				public int compare(Integer[] o1, Integer[] o2) {
					int res = o1[0]*o1[1] - o2[0]*o2[1];
					return res==0?o1[0]-o2[0]:res;
				}
			});
			int size = list.size();
			System.out.print("#"+t+" "+size+" ");
			for (int i = 0; i < size; i++) {
				Integer[] res = new Integer[2];
				res = list.get(i);
				System.out.print(res[0]+" "+res[1]+" ");
			}
			System.out.println();
		}
	}
	private static void search(int r, int c, List<Integer[]> list) {
		int nr,nc,pr=r,pc=c,cnt=1;
		Integer[] data = new Integer[2];
		while(true) {
			nr = pr+dir[0][0];
			nc = pc+dir[0][1];
			if(nc==N) {
				data[1] = cnt;
				break;
			}
			else {
				if(map[nr][nc]==0 ) {
					data[1] = cnt;
					break;
				}
				else {
					cnt++;
					pr = nr;
					pc = nc;
				}
			}
		}
		pr = r; pc=c; cnt=1;
		while(true) {
			nr = pr+dir[1][0];
			nc = pc+dir[1][1];
			if(nr==N) {
				data[0] = cnt;
				break;
			}
			else {
				if(map[nr][nc]==0 ) {
					data[0] = cnt;
					break;
				}else {
					cnt++;
					pr = nr;
					pc = nc;
				}
			}
		}
		list.add(data);
		for (int i = r; i < r+data[0]; i++) {
			for (int j = c; j < c+data[1]; j++) {
				visit[i][j]=true;
			}
		}
	}
}
