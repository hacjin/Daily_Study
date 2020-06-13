package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4613_러시아국기같은깃발_이학진 {
	static int N,M;
	static char map[][];
	static int cnt[][];
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			cnt = new int[N][3];	// W B R
			for (int n = 0; n < N; n++) {
				map[n] = br.readLine().toCharArray();
				for (int m = 0; m < M; m++) {
					if(map[n][m]=='W') cnt[n][0]++;
					else if(map[n][m]=='B') cnt[n][1]++;
					else cnt[n][2]++;
				}
			}
			min=Integer.MAX_VALUE;
			int sum = cnt[0][1]+cnt[0][2] + cnt[N-1][0]+cnt[N-1][1];
			flag(1,sum,0);
			
			System.out.println("#"+t+" "+min);
		}
	}
	private static void flag(int index, int sum, int cur) {
		if(index==N-1 && cur>0) {
			if(min>sum) min = sum;
			return;
		}else if(index==N-1 && cur < 1) {
			return;
		}
		int w = cnt[index][1] + cnt[index][2];
		int b = cnt[index][0] + cnt[index][2];
		int r = cnt[index][0] + cnt[index][1];
		switch(cur) {
			case 0 :
				flag(index+1,sum+w,cur);
				flag(index+1,sum+b,cur+1);
			break;
			case 1 : 
				flag(index+1,sum+b,cur);
				flag(index+1,sum+r,cur+1);
				break;
			case 2 : 
				flag(index+1,sum+r,cur);
				break;
		}
	}
}
