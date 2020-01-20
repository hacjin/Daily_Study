package subset_0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubSet2Test {

	// N : 입력받을 숫자 개수
	// 입력받은 수들로 가능한 부분집합 모두 출력 : 재귀로 구현
	static int N;
	static boolean selected[];
	static int input[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		selected = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		subset(0);
	}

	public static void subset(int index) {
		if (index == N) {
			for (int j = 0; j < N; j++) {
				System.out.print((selected[j]?input[j]:"X")+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i >=0 ; i--) {
			selected[index] = i%2==1?true:false;
			subset(index + 1);
		}
	}
}
