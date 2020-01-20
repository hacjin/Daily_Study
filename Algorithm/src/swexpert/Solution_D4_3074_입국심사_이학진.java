package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3074_입국심사_이학진 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); 
			int M = Integer.parseInt(st.nextToken());
			Long time[] = new Long[N];
			for (int i = 0; i < time.length; i++) {
				time[i] = Long.parseLong(br.readLine());
			}
			long min = 0;
			long max = time[N-1]*M;
			long premax=max;
			long man = 0;
			while(true) {
				if(min==max) break;
				man = 0;
				for (int i = 0; i < time.length; i++) {
					man += max/time[i];
				}
				if(man>=M) {
					premax = max;
					max = (min+max)/2;
				}else {
					min = max;
					max = (min+premax)/2;
				}
			}
			System.out.println("#"+t+" "+ premax);
		}
	}
}
