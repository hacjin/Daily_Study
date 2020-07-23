package baekjoon;

import java.io.*;
import java.util.*;

/*
 * N과 M(2) 백준 문제
 * 2020-07-23 15:40분 시작
 * 2020-07-23 15:45분 끝
 * 
 */
public class Main_B15650_N과M2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		int arr[] = new int[M];
		// 매개변수 index와 N
		subset(0, 1, N, M, sb, arr);
		System.out.println(sb.toString());
	}

	public static void subset(int index, int cur, int N, int M, StringBuilder sb, int[] arr) {
		if (index == M) {
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = cur; i <= N; i++) {

			arr[index] = i;
			subset(index + 1, i+1, N, M, sb, arr);
		}
	}
}
