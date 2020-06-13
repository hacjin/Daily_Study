package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2261_경로찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N,K,start,end;
		int arr[][];
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][K];
		String str;
		
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < K; j++) {
				arr[i][j] = (str.charAt(j)-'0');
			}
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		System.out.println("////"+ start + "////" + end);
		
	}
}
