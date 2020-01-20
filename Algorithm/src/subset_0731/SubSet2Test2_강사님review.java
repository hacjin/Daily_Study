package subset_0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubSet2Test2_강사님review {

	// N : 입력받을 숫자 개수
	// 입력받은 수들로 가능한 부분집합 모두 출력 : 재귀로 구현
	static int N, target;
	static boolean selected[];
	static int input[];
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		input = new int[N];
		selected = new boolean[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		subset(0);
		System.out.println("총 경우의 수 : " + count);
	}

	public static void subset(int index) {
		if (index == N) {
			int total =0;
			for (int j = 0; j < N; j++) {
//				System.out.print((selected[j] ? input[j] : "X") + " ");
				if (selected[j]) {
					total += input[j];
				}
			}
			if (total == target) {
				count++;
				for (int i = 0; i < N; i++) {
					if(selected[i]) {
						System.out.print(input[i]+"\t");
					}
				}
				System.out.println();
			}
//			System.out.println();
			return;
		}
		for (int i = 1; i >= 0; i--) {
			selected[index] = i % 2 == 1 ? true : false;
			subset(index + 1);
		}
	}
}
