package 미해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1654_랜선자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int map[] = new int[K];
		for (int i = 0; i < K; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(map);
		int min = map[0];
		int max = map[K-1];
		int res;
		int maxlen = 0;
		for (int i = max-min; i > 0; i--) {
			res = 0;
			for (int j = 0; j < K; j++) {
				res += (map[j]/i);
			}
			if(res==N) {maxlen = i; break;}
		}
		System.out.println(maxlen);
	}
}
