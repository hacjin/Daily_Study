package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1018_체스판다시칠하기 {
	static int N,M;
	static char map[][];
	static boolean visit[][];
	static int min = Integer.MAX_VALUE;
	static int dir[][] = {{0,1},{1,0},{0,-1},{1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			map[r] = str.toCharArray();
		}
		
		for (int r = 0; r <= N-8; r++) {
			for (int c = 0; c <= M-8; c++) {
				visit = new boolean[N][M];
				left(r,c,map[r][c]);
			}
		}
		for (int r = 0; r <= N-8; r++) {
			for (int c = M-1; c >= 7; c--) {
				visit = new boolean[N][M];
				right(r,c,map[r][c]);
			}
		}
		for (int r = N-1; r >= 7; r--) {
			for (int c = 0; c <= M-8; c++) {
				visit = new boolean[N][M];
				left_bot(r,c,map[r][c]);
			}
		}
		for (int r = N-1; r >= 7; r--) {
			for (int c = 0; c <= M-8; c++) {
				visit = new boolean[N][M];
				right_bot(r,c,map[r][c]);
			}
		}
		
		System.out.println(min);
	}
	private static void right_bot(int r, int c, char tmp) {
		int cnt = 0;
		if(c-7 < 0 || r-7< 0) return;
		for (int i = r; i >= r-7; i--) {
			if(!visit[i][c]) tmp =map[i][c];
			for (int j = c; j >= c-7; j--) {
				if(j!=c) {
					if(tmp==map[i][j]) {
						visit[i][j] = true;
						cnt++;
						if(tmp=='B') tmp='W';
						else tmp = 'B';
					}
					else {
						tmp = map[i][j];
					}
				}
			}
			if(visit[i][c]) {
				if(map[i][c]=='W') tmp='B';
				else tmp='W';
			}
			else {
				tmp = map[i][c];
			}
			if(i-1 >= r-7 && tmp==map[i-1][c]) {
				cnt++;
				visit[i-1][c] = true;
				if(tmp=='B') tmp='W';
				else tmp = 'B';
			}
		}
		if(cnt<min) {
			min = cnt;
		}
	}
	private static void left_bot(int r, int c, char tmp) {
		int cnt = 0;
		if(c+8>M || r-7< 0) return;
		for (int i = r; i >= r-7; i--) {
			if(!visit[i][c]) tmp =map[i][c];
			for (int j = c; j < c+8; j++) {
				if(j!=c) {
					if(tmp==map[i][j]) {
						visit[i][j] = true;
						cnt++;
						if(tmp=='B') tmp='W';
						else tmp = 'B';
					}
					else {
						tmp = map[i][j];
					}
				}
			}
			if(visit[i][c]) {
				if(map[i][c]=='W') tmp='B';
				else tmp='W';
			}
			else {
				tmp = map[i][c];
			}
			if(i-1 >= r-7 && tmp==map[i-1][c]) {
				cnt++;
				visit[i-1][c] = true;
				if(tmp=='B') tmp='W';
				else tmp = 'B';
			}
		}
		if(cnt<min) {
			min = cnt;
		}
	}
	private static void right(int r, int c, char tmp) {
		int cnt = 0;
		if(r+8>N || c-7< 0) return;
		for (int i = r; i < r+8; i++) {
			if(!visit[i][c]) tmp =map[i][c];
			for (int j = c; j >= c-7; j--) {
				if(j!=c) {
					if(tmp==map[i][j]) {
						visit[i][j] = true;
						cnt++;
						if(tmp=='B') tmp='W';
						else tmp = 'B';
					}
					else {
						tmp = map[i][j];
					}
				}
			}
			if(visit[i][c]) {
				if(map[i][c]=='W') tmp='B';
				else tmp='W';
			}
			else {
				tmp = map[i][c];
			}
			if(i+1 < r+8 && tmp==map[i+1][c]) {
				cnt++;
				visit[i+1][c] = true;
				if(tmp=='B') tmp='W';
				else tmp = 'B';
			}
		}
		if(cnt<min) {
			min = cnt;
		}
	}
	private static void left(int r, int c,char tmp) {
		int cnt = 0;
		if(r+8>N || c+8>M) return;
		for (int i = r; i < r+8; i++) {
			if(!visit[i][c]) tmp = map[i][c]; 
			for (int j = c; j < c+8; j++) {
				if(j!=c) {
					if(tmp==map[i][j]) {
						visit[i][j] = true;
						cnt++;
						if(tmp=='B') tmp='W';
						else tmp = 'B';
					}
					else {
						tmp = map[i][j];
					}
				}
			}
			if(visit[i][c]) {
				if(map[i][c]=='W') tmp='B';
				else tmp='W';
			}
			else {
				tmp = map[i][c];
			}
			if(i+1 < r+8 && tmp==map[i+1][c]) {
				cnt++;
				visit[i+1][c] = true;
				if(tmp=='B') tmp='W';
				else tmp = 'B';
			}
		}
		if(cnt<min) {
			min = cnt;
		}
	}
}
