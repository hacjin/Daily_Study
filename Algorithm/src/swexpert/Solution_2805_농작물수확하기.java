package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805_농작물수확하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st;
		int N,T,sum;
		int map[][];
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = st.charAt(j)-'0';
				}
			}
			sum = 0;
			for (int i = 0; i <= N/2; i++) {
				for (int j = N/2-i; j < N/2-i+(i*2+1); j++) {
					sum += map[i][j];
				}
			}
			for (int i = N/2+1; i < N; i++) {
				for (int j = N/2-(N-1-i) ; j < (N/2-(N-1-i))+(N-1-i)*2+1; j++) {
					sum += map[i][j];
				}
			}
			System.out.println("#"+(t+1)+" "+sum);
		}
	}
}
