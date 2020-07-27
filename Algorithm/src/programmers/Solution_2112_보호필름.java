package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2112_보호필름 {
	static int D,W,K;
	static int map[][];
	static int chemi;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			int[][] tmp= new int[D][W];
			chemi = D+1;
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					tmp[i][j] = map[i][j];
				}
			}
			
			/*
			 * 1.0열부터 W까지 K를 만족하는지 체크
			 * 2.만족할 경우 0 출력
			 * 3.아닐 경우 최소 2회의 약품 처리
			 */
			if(K==1 || isOk(map)) System.out.println("#"+t+" "+0);
			else {
				for (int i = 0; i < D; i++) {
					fill(tmp,i,0);
					dfs(1,i,tmp);
					
					fill(tmp,i,1);
					dfs(1,i,tmp);
					back(tmp,i);
				}
				System.out.println("#"+t+" "+chemi);
			}
		}
	}
	private static void back(int[][] tmp, int row) {
		for (int j = 0; j < W; j++) {
			tmp[row][j] = map[row][j];
		}
	}
	private static void fill(int[][] tmp, int row, int value) {
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < W; j++) {
				if(i==row) tmp[i][j] = value;
			}
		}
	}
	private static void dfs(int index, int row, int[][] tmp) {
		if(index > chemi) return;
		if(isOk(tmp) && index < chemi) {
			chemi = index;
			return;
		}
		for (int i = row+1; i < D; i++) {
			// A로 채울때
			fill(tmp,i,0);
			dfs(index+1,i,tmp);
			
			// B로 채울때
			fill(tmp,i,1);
			dfs(index+1,i,tmp);
			back(tmp,i);
		}
	}
	private static boolean isOk(int[][] arr) {
		boolean chk = true;
		for (int i = 0; i < W; i++) {
			int cnt = 1;
			for (int j = 0; j < D-1; j++) {
				if(arr[j][i]==arr[j+1][i]) cnt++;
				else {
					if(cnt>=K) break;
					cnt = 1;
				}
			}
			if(cnt<K) {
				chk = false;
				break;
			}
		}
		return chk;
	}
}
