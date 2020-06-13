package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11399_ATM {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N;
		int p[];
		N = Integer.parseInt(br.readLine());
		p = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		sort(p);
		System.out.println(make_min(p));	
	}

	private static int make_min(int[] p) {
		int n = p.length-1;
		int max = 0,befor=0;
		for (int i = 1; i <= n; i++) {
			befor = befor + p[i];
			max += befor;
		}
		return max;
	}
	private static void sort(int[] p) {
		int n = p.length-1;
		
		int tmp;
		for (int i = 1; i <= n-1; i++) {
			for (int j = i+1; j <= n; j++) {
				if(p[i]>p[j]) {
					tmp = p[i];
					p[i] = p[j];
					p[j] = tmp;
				}
			}
		}
	}
}
