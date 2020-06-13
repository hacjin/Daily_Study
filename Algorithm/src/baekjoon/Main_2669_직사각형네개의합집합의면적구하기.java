package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2669_직사각형네개의합집합의면적구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int map[][] = new int[101][101];
		int sr,sc,er,ec;
		int res=0;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());
			
			for (int r = sr; r < er; r++) {
				for (int c = sc; c < ec; c++) {
					map[r][c] = 1;
				}
			}
		}
		
		for (int r = 1; r < 101; r++) {
			for (int c = 1; c < 101; c++) {
				if(map[r][c]==1) res++;
			}
		}
		System.out.println(res);
	}
}
