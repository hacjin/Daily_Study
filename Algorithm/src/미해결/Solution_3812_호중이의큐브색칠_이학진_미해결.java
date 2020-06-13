package 미해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3812_호중이의큐브색칠_이학진_미해결 {
	static int X,Y,Z,A,B,C,N;
	static long col[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			Z = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			col = new long[N];
			
//			for (int i = 0; i < X; i++) {
//				for (int j = 0; j < Y; j++) {
//					for (int k = 0; k < Z; k++) {
//						int val = Math.abs(i-A)+Math.abs(j-B)+Math.abs(k-C);
//						col[val%N]++;
//					}
//				}
//			}
			System.out.print("#"+t+" ");
			for (long c : col) {
				System.out.print(c+" ");
			}
			System.out.println();
		}
	}
}
