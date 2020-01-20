package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1018_체스판다시칠하기2 {
	static int N,M;
	static char map[][];
	static char black[] = {'B','W','B','W','B','W','B','W'};
	static char white[] = {'W','B','W','B','W','B','W','B'};
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int r = 0; r < N; r++) {	
			map[r] = br.readLine().toCharArray();
		}
		
		for (int r = 0; r < N-7; r++) {
			for (int c = 0; c < M-7; c++) {
				find(r,c);
			}
		}
		System.out.println(min);
	}

	private static void find(int r, int c) {
		int cnt = 0;
		
		for (int i = r; i < r+8; i++) {
			if(i%2==0) {
				for (int j = c; j < c+8; j++) {
					if(map[i][j]!=black[j-c]) cnt++;
				}
			}else {
				for (int j = c; j < c+8; j++) {
					if(map[i][j]!=white[j-c]) cnt++;
				}
			}
		}
		if(min>cnt) min = cnt;
		
		cnt=0;
		for (int i = r; i < r+8; i++) {
			if(i%2==0) {
				for (int j = c; j < c+8; j++) {
					if(map[i][j]!=white[j-c]) cnt++;
				}
			}else {
				for (int j = c; j < c+8; j++) {
					if(map[i][j]!=black[j-c]) cnt++;
				}
			}
		}
		if(min>cnt) min = cnt;
	}
}
