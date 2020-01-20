package 미해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17845_수강과목_미해결 {
	static int N,K;
	static int bt[];	// 과목별 공부시간
	static int bi[];	// 과목별 중요도
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bt = new int[K];
		bi = new int[K];
		for (int i = 0; i < K; i++) {
		}
	}
}
