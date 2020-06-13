package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5569_출근경로 {
	static int w,h;
	static int total = 0;
	static int dir[][] = {{0,1},{1,0}}; //0 : 동    1 : 북
	static int d = 0;
	static boolean ro = true;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		

		move(1,1);
	
	
	}
	private static void move(int r, int c) {
		
		move(r+1,c);	// 행만 갈때
		move(r,c+1);	// 열만 갈때
	}
}
