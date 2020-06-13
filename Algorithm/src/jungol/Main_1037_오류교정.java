package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1037_오류교정 {
	static int N;
	static int map[][];
	static int rcnt[],ccnt[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		rcnt = new int[N];
		ccnt = new int[N];
		int nr, nc;
		int cr=0, cc=0;

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < N; r++) {
			nr = 0;
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1) {
					nr += 1;		// r행에 해당하는 1의 갯수
				}
			}
			rcnt[r] = nr;
		}
		for (int r = 0; r < N; r++) {
			nc = 0;
			for (int c = 0; c < N; c++) {
				if (map[c][r] == 1) {
					nc += 1;		// r열에 해당하는 1의 갯수
				}
			}
			ccnt[r] = nc;
		}
		
		int Rcnt=0, Ccnt=0;
		for (int r = 0; r < N; r++) {
			if(rcnt[r]%2==1) {
				cr = r;
				Rcnt++;
			}
			if(ccnt[r]%2==1) {
				cc = r;
				Ccnt++;
			}
		}
		int cnt = 0;
		if(Rcnt>1 || Ccnt>1) cnt = 2;
		else if(Rcnt==1 && Ccnt==1) cnt = 1;
		
		switch (cnt) {
		case 0:
			System.out.println("OK");
			break;
		case 1:
			if((rcnt[cr]-1)%2==0 && (ccnt[cc]-1)%2==0) {
				cr++; cc++;
				System.out.println("Change bit ("+cr+","+cc+")");
				break;
			}
		default:
			System.out.println("Corrupt");
			break;
		}
	}
}
