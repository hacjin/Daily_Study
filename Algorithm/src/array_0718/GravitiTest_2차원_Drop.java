package array_0718;

import java.util.ArrayList;
import java.util.Scanner;

public class GravitiTest_2차원_Drop {

	static int N, arr[][];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			int c = sc.nextInt(); // 7높이
			// 회전한 결과로 배열에 저장
			for (int j = 0; j < c; j++) {
				arr[i][j] = 1;
			}
		}
		System.out.println(drop());

	}

	private static int drop() {
		int max = 0,tmp=0;
		for (int i = 0; i < N; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = N - 1; j >= 0; j--) {
				if (arr[j][i] != 0) {
//					list.add(new Integer(arr[j][i]));
// 					오토박싱으로 Integer 선언없이 가능하다
					list.add(arr[j][i]);
					arr[j][i] = 0; // 해당 자리 기본값으로 초기화
					tmp= N-(j+list.size());
					if(max < tmp) max = tmp;
				}
			}
			int size = list.size();
			if (size > 0) {
				for (int k = 1; k <=size; k++) {
					arr[N-k][i] = list.get(k - 1);
				}
			}
		}

		return max;
	}
}
