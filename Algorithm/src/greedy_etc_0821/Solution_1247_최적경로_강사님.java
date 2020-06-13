package greedy_etc_0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_최적경로_강사님 {
	static int HX,CX = 0;
	static int HY,CY = 0;
	static int min = Integer.MAX_VALUE;
	static int[][] customer = null;
	static int N = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			CX = Integer.parseInt(st.nextToken());
			CY = Integer.parseInt(st.nextToken());
			HX = Integer.parseInt(st.nextToken());
			HY = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 2; k++) {
					customer[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			go(0, CX, CY, 0, 0);
			System.out.println("#"+i+" "+min);
		}
	}
	
	private static void go(int count, int bx, int by, int visited, int cost) {
		if(cost>=min) return;	// 가지치기
		if(count==N) {
			cost += Math.abs(bx-HX)+Math.abs(by-HY);
			if(cost<min) min = cost;
			return;
		}
		for (int i = 0; i < N; i++) {
			if((visited & (1<<i))==0) {
				int tmp = Math.abs(bx-customer[i][0])+Math.abs(by-customer[i][1]);
				go(count+1, customer[i][0], customer[i][1], visited | (1<<i)
						, cost+tmp);
			}
		}
	}
}
