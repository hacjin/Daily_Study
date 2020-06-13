package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798_블랙잭 {
	static int card[];
	static int N, M, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     	StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		card = new int[N];
		st = new StringTokenizer(br.readLine());
		int size = st.countTokens();
		for (int i = 0; i < size; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		perm(0, 0, 0);
		System.out.println(max);

	}

	public static void perm(int index, int sum, int cnt) {
		if (cnt == 3 ) {	// 조건을 만족할 경우
			if (sum <= M && sum > max) {
				max = sum;
			}
			return;
		}
		// 기저 사례
		if(index>=N || cnt > 3 || sum > M) return;
		
		// 해당 카드 뽑을때
		perm(index + 1, sum + card[index], cnt + 1);
		// 해당 카드 안 뽑을 때
		perm(index + 1, sum, cnt);
	}
}
