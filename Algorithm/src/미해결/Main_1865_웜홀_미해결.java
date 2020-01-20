package 미해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1865_웜홀_미해결 {
	static int N,M,W;
	static int map[][];
	static int distance[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int s = Integer.parseInt(st.nextToken())-1;
				int e = Integer.parseInt(st.nextToken())-1;
				int v = Integer.parseInt(st.nextToken());
				map[s][e] = map[e][s] = v;
			}
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int s = Integer.parseInt(st.nextToken())-1;
				int e = Integer.parseInt(st.nextToken())-1;
				int v = Integer.parseInt(st.nextToken());
				map[s][e] = v*-1;
			}
		}
		
	}
}
