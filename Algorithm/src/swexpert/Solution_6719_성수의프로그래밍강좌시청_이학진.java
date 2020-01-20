package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6719_성수의프로그래밍강좌시청_이학진 {
	static int N,K;
	static int[] M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			M = new int[N];
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				M[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(M);
			int s = 0;
			for (int i = N-1; i >= 0; i--) {
				if(s==K) break;
				s++;
			}
			double cur = 0;
			for (int i = N-s; i < N-1; i++) {
				cur = (cur+M[i])/2;
			}
			cur = (cur+M[N-1])/2;
			
			System.out.println("#"+t+" "+String.format("%.6f",cur ));
		}
	}
}
