package baekjoon;

import java.io.*;
import java.util.*;
/*
 * N-Queen 9663 백준 문제
 * 2020-07-23 16:17분 시작
 * 2020-07-23 미해결
 */
public class Main_B9663_NQueen {
	static int result = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][N];
		go(0,0,0,arr,N);
		System.out.println(result);
	}
	private static void go(int cnt, int x, int y, int[][] arr, int N) {
		// 기저 조건 1. 모든 행을 다돌았을때, 퀸 갯수가 N개일때
		if(x==N) return;
		if(cnt == N) {
			result++; return;
		}
		// 모든 열을 다돌았을 때 다음 행
		if(y==N) { x++; y=0; }
		
		// 팔방에 포함되는지 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]==1) {
					if(x==i || y==j || Math.abs(i-x) == Math.abs(j-y)) return;
				}
			}
		}
		arr[x][y] = 1;
		go(cnt+1,x,y++,arr,N);
		arr[x][y] = 0;
	}

}
