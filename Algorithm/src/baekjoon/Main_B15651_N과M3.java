package baekjoon;

import java.io.*;
import java.util.*;

/*
 * N과 M(3) 백준 문제
 * 2020-07-23 15:45분 시작
 * 2020-07-23 16:03분 끝
 * 
 */
public class Main_B15651_N과M3 {
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
		subset(0,N,M,arr,sb);
		System.out.println(sb.toString());
	}

	private static void subset(int index, int n, int m, char[] arr, StringBuilder sb) {
		if(index == m) {
			sb.append(arr);
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= n; i++) {
			arr[2*index] = (char)(i+'0');
			subset(index+1,n,m,arr,sb);
		}
	}
}
