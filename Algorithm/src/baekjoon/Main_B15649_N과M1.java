package baekjoon;

import java.io.*;
import java.util.*;
/*
 * N과 M(1) 백준 문제
 * 2020-07-23 15:14분 시작
 * 2020-07-23 15:36분 끝
 * 
 */
public class Main_B15649_N과M1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		int arr[] = new int[M];
		boolean visit[] = new boolean[N+1];
		// 매개변수 index와 N
		subset(0,N,M,sb,arr,visit);
		System.out.println(sb.toString());
	}
	public static void subset(int index, int N, int M, StringBuilder sb,int[] arr, boolean[] visit) {
		if(index == M) {
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N ; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[index] = i;
				subset(index+1,N,M,sb,arr,visit);
				visit[i] = false;
			}
		}
	}
}
