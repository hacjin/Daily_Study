package 미해결;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6987_월드컵_이학진_미해결 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			int map[][] = new int[6][3];		// 0 : 승  1 : 무 2 :패 
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 3; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			
		}
	}
}
