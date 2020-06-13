package 미해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_J1113_119구급대_미해결 {
	static int N,M;
	public static void main(String[] args) throws IOException {
		int gn,gm;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		gn = Integer.parseInt(st.nextToken());
		gm = Integer.parseInt(st.nextToken());
	}
}
