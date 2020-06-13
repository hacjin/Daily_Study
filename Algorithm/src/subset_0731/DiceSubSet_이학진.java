package subset_0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DiceSubSet_이학진 {
	static int dice[] = { 1, 2, 3, 4, 5, 6 };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sum(0, 0, "");
	}

	public static void sum(int count, int sum, String str) {
		if (sum == M) {
			System.out.printf(str + "\n");
			return;
		}
		if (count == N) {
			return;
		}
//		sum(count + 1, index + 1, selected | 1 << index, sum + dice[index], str + dice[index] + " ");
//		sum(count, index + 1 , selected, sum, str);
		
		for (int index = 0; index < dice.length; index++) {
			sum(count + 1, sum + dice[index], str + dice[index] + " ");
		}

	}
}
