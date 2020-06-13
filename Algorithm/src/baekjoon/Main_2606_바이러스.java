package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N,L;
		int num[];
		int link[][];
		N = Integer.parseInt(br.readLine());
		L = Integer.parseInt(br.readLine());
		num = new int[N];
		link = new int[L][2];
		
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				link[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
	}
}
