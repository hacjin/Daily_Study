package subset_0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubSet2Test2_1 {

	// N : 입력받을 숫자 개수
	// 입력받은 수들로 가능한 부분집합 모두 출력 : 재귀로 구현
	static int N, target;
	static int input[];
	static int count;
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
		/*subset(0, 0);
		System.out.println("총 경우의 수 : " + count);*/
		subset2(0, 0,"");
		System.out.println("총 경우의 수 : " + count);
	}

	public static void subset(int index, int total) {
		if (index == N) {
			if (total == target) {
				count++;
			}
			return;
		}
		// 선택 되었을시
		subset(index + 1, total + input[index]);
		// 선택 되지 않았을시
		subset(index + 1, total);
	}
	public static void subset2(int index, int total,String result) {
		if (index == N) {
			if (total == target) {
				count++;
				System.out.println(result);
			}
			return;
		}
		// 선택 되었을시
		subset2(index + 1, total + input[index],result+input[index]+" ");
		// 선택 되지 않았을시
		subset2(index + 1, total,result);
	}
}
