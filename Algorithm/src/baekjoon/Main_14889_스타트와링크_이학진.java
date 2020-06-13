package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크_이학진 {
	static int N;
	static boolean chk[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int map[][];
		chk = new boolean[N];
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int count = 0;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		choice(0,0);
	}

	private static void choice(int index,int cnt) {
		if(index == N) return;
		
		
		choice(index+1,cnt+1);
		choice(index+1,cnt);
		
	}
}
