package swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드_이학진 {
	static int H,W,N;
	static char map[][];
	static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};	// 상 하 좌 우
	static int TR,TC;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("in/input (1).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		char insert[];
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for (int r = 0; r < H; r++) {
				String in = br.readLine();
				for (int c = 0; c < W; c++) {
					map[r][c] = in.charAt(c);
					if(map[r][c]=='<' || map[r][c]=='>'
							|| map[r][c]=='v' || map[r][c]=='^') {TR = r; TC=c;}
				}
			}
			N = Integer.parseInt(br.readLine());
			String in2 = br.readLine();
			insert = in2.toCharArray();
			
			for (int i = 0; i < N; i++) {
				action(insert[i]);
			}
			System.out.print("#"+t+" ");
			display();
		}
	}
	private static void display() {
		for (char[] is : map) {
			System.out.println(is);
		}
	}
	private static void action(char c) {
		int d=0;
		
		if(map[TR][TC]=='^') d=0;
		else if(map[TR][TC]=='v') d=1;
		else if(map[TR][TC]=='<') d = 2;
		else if (map[TR][TC]=='>') d =3;
		
		int nr=TR,nc=TC;
		switch(c) {
		case 'S':
			while(true) {
				nr = nr + dir[d][0];
				nc = nc + dir[d][1];
				if(nr<0 || nr==H || nc<0 || nc==W) break;
				else {
					if(map[nr][nc]=='*') {map[nr][nc]='.'; break;}
					else if(map[nr][nc]=='#') break;
				}
			}
			break;
		case 'U':
			d = 0;
			nr = nr+ dir[d][0];
			nc = nc+ dir[d][1];
			if(nr<0 || nr==H || nc<0 || nc==W) {map[TR][TC] = '^';break;}
			else {
				if(map[nr][nc]=='.') {
					map[TR][TC] = '.';
					TR=nr;TC=nc;
					map[TR][TC] = '^';
				}else
				map[TR][TC] = '^';
			}
			break;
		case 'D':
			d = 1;
			nr = nr+ dir[d][0];
			nc = nc+ dir[d][1];
			if(nr<0 || nr==H || nc<0 || nc==W) {map[TR][TC] = 'v';break;}
			else {
				if(map[nr][nc]=='.') {
					map[TR][TC] = '.';
					TR=nr;TC=nc;
					map[TR][TC] = 'v';
				}else
				map[TR][TC] = 'v';
			}
			break;
		case 'L':
			d = 2;
			nr = nr+ dir[d][0];
			nc = nc+ dir[d][1];
			if(nr<0 || nr==H || nc<0 || nc==W) {map[TR][TC] = '<';break;}
			else {
				if(map[nr][nc]=='.') {
					map[TR][TC] = '.';
					TR=nr;TC=nc;
					map[TR][TC] = '<';
				}else
				map[TR][TC] = '<';
			}
			break;
		case 'R':
			d = 3;
			nr = nr+ dir[d][0];
			nc = nc+ dir[d][1];
			if(nr<0 || nr==H || nc<0 || nc==W) {map[TR][TC] = '>';break;}
			else {
				if(map[nr][nc]=='.') {
					map[TR][TC] = '.';
					TR=nr;TC=nc;
					map[TR][TC] = '>';
				}else
				map[TR][TC] = '>';
			}
			break;
		}
	}
}
