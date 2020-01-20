package subset_0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DiceSubSet_강사님review {
	static int numbers[];
	static int N, M, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		Subset(0, 0);
		System.out.println("경우의 수 : " + count);
	}

	public static void Subset(int index, int total) {
		if(total > M) {
			return;
		}
		if (index == N) {
			if (total == M) {
				count++;
				System.out.println(Arrays.toString(numbers));
			}
			return;
		}
		for (int i = 1; i <= 6; i++) { // 1~6의 주사위 눈 시도
			numbers[index] = i; // 선택
			Subset(index + 1, total + numbers[index]);
		}

	}
}
