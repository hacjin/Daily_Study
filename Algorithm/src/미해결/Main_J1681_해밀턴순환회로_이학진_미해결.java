package 미해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_J1681_해밀턴순환회로_이학진_미해결 {
	static int N,min=Integer.MAX_VALUE;
	static int mat[][];
	static boolean visit[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		mat = new int[N][N];
		visit = new boolean[N];
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				mat[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		/*
		for (int i = 0; i < N; i++) {	// 경유지
			for (int j = 0; j < N; j++) { // 출발지
				if(i!=j && mat[j][i]!=0) {
					for (int k = 0; k < N; k++) { // 도착지
						if(i!=k && j!=k && mat[i][k]!=0) {
							if(mat[j][k]==0) {
								mat[j][k] = mat[j][i] + mat[i][k];
							}else {
								if(mat[j][k] > mat[j][i] + mat[i][k]) {
									mat[j][k] = mat[j][i] + mat[i][k];
								}
							}
						}
					}
				}
			}
		}*/
		// 갈때 출발지 1로 고정 
		
		System.out.println(mat[0][N-1]+mat[N-1][0]);
	}
}
