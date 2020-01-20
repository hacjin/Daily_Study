package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기_이학진 {
	static int map[][];
	static int blue,white;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		int b=0;
		int w=0;
		for (int r = 1; r <= N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==1) b++;
				else w++;
			}
		}
		if(b==N*N) blue++;
		else if(w==N*N) white++;
		else div(1,N,1,N);
		
		System.out.println(white);
		System.out.println(blue);
	}

	private static void div(int minr,int maxr,int minc,int maxc) {
		int count = 2;
		
		int bcnt =0;
		for (int r = minr; r <= (minr+maxr-1)/count; r++) {
			for (int c = minc; c <= (minc+maxc-1)/count; c++) {
				if(map[r][c]==1) bcnt++;
			}
		}
		if(bcnt==0)  {white++;}
		else if(bcnt==((maxr-minr+1)/count)*((maxr-minr+1)/count)) {blue++;}
		else div(minr,(minr+maxr-1)/count,minc,(minc+maxc-1)/count);
		
		bcnt=0;
		for (int r = minr; r <= (minr+maxr-1)/count; r++) {
			for (int c = (minc+maxc+1)/count; c <= maxc; c++) {
				if(map[r][c]==1) bcnt++;
			}
		}
		if(bcnt==0)  {white++;}
		else if(bcnt==((maxr-minr+1)/count)*((maxr-minr+1)/count)) {blue++;}
		else div(minr,(minr+maxr-1)/count,(minc+maxc+1)/count,maxc);
		
		bcnt=0;
		for (int r = (minr+maxr+1)/count; r <= maxr; r++) {
			for (int c = minc; c <= (minc+maxc-1)/count; c++) {
				if(map[r][c]==1) bcnt++;
			}
		}
		if(bcnt==0)  {white++;}
		else if(bcnt==((maxr-minr+1)/count)*((maxr-minr+1)/count)) {blue++;}
		else div((minr+maxr+1)/count,maxr,minc,(minc+maxc-1)/count);
		
		bcnt=0;
		for (int r = (minr+maxr+1)/count; r <= maxr; r++) {
			for (int c = (minc+maxc+1)/count; c <= maxc; c++) {
				if(map[r][c]==1) bcnt++;
			}
		}
		if(bcnt==0)  {white++;}
		else if(bcnt==((maxr-minr+1)/count)*((maxr-minr+1)/count)) {blue++;}
		else div((minr+maxr+1)/count,maxr,(minc+maxc+1)/count,maxc);
	}
}
