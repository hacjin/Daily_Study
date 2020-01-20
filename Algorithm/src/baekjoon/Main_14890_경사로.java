package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14890_경사로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N,L;
		int map[][];
		int slidec[],slider[];
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int [N+1][N+1];
		slidec = new int [N+1];
		slider = new int [N+1];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 1; r < N; r++) {
			for (int c = 1; c < N; c++) {
				if(map[r][c] < map[r][c+1]) {
					slidec[c] += 1;
				}
				if(map[r][c] > map[r][c+1]) {
					slidec[c] -= 1;
				}
				if(map[c][r] < map[c+1][r]) {
					slider[c] += 1;
				}
				if(map[c][r] > map[c][r+1]) {
					slider[c] -= 1;
				}
			}
		}
		
	}
}
