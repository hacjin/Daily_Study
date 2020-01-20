package subset_0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubSet2Test_2 {

	// N : 입력받을 숫자 개수
	// 입력받은 수들로 가능한 부분집합 모두 출력 : 재귀로 구현
	static int N, target;
//	static int selected;
	static int input[];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		input = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		subset(0, 0);
	}

	public static void subset(int index, int selected) {
		if (index == N) {
			for (int i = 0; i < N; i++) {
				if((selected&1<<i)!=0) {
					System.out.printf(input[i]+"\t");
				}
			}
			System.out.println();
			return;
		}
		subset(index + 1, selected | 1 << index);
		subset(index + 1, selected);
	}
}
