package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1206_View {
	static int N,cnt;
	static int map[];
	static boolean left,right;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			cnt = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
				int lm=0,rm=0;
				if(i == N-2) {
					break;
				}
				if(i>1) {
					if(map[i-1] < map[i] && map[i-2]<map[i]) {
						if(map[i-1]>map[i-2]) {
							lm =  map[i-1];
						}else if(map[i-1]<=map[i-2]) {
							lm =  map[i-2];
						}
						left = true;
					}
					if(map[i+1] < map[i] && map[i+2]<map[i]) {
						if(map[i+1]>map[i+2]) {
							rm =  map[i+1];
						}else if(map[i+1]<=map[i+2]) {
							rm =  map[i+2];
						}
						right = true;
					}
					if(left&&right) {
						if(lm>rm) {
							cnt = cnt + map[i]-lm;
						}else if (rm>=lm) {
							cnt = cnt + map[i]-rm;
						}
						left = false;
						right = false;
					}else {
						left = false;
						right = false;
					}
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}
