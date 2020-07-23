package baekjoon;

import java.io.*;
import java.util.*;

/*
 * N과 M(4) 백준 문제
 * 2020-07-23 16:06분 시작
 * 2020-07-23 16:13분 끝
 * 
 */
public class Main_B15652_N과M4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		char arr[] = new char[2*M];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ' ';
		}
		subset(0,1,N,M,sb,arr);
		System.out.println(sb);
	}

	private static void subset(int index,int cur, int N, int M, StringBuilder sb, char[] arr) {
		if(index == M) {
			sb.append(arr).append("\n");
			return;
		}
		for (int i = cur; i <= N; i++) {
			arr[2*index] = (char)(i+'0');
			subset(index+1,i,N,M,sb,arr);
		}
	}
}
