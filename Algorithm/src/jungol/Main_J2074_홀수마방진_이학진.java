package jungol;

import java.util.Scanner;

public class Main_J2074_홀수마방진_이학진 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int map[][] = new int[N][N];
		
		int count = 1;
		int mid = (N-1)/2;
		map[0][mid] = count;
		int r=0;
		int c=mid;
		while(count<N*N) {
			if(count%N!=0) {
			r--;
			c--;
			if(r<0) {
				r = N-1;
			}
			if(c<0 ) {
				c = N-1;
			}
			}
			else {
				r++;
				if(r==N) {
					r=0;
				}
			}
			map[r][c] = ++count;
		}
		for (int[] is : map) {
			for (int out : is) {
				System.out.print(out+" ");
			}
			System.out.println();
		}
	}
}
