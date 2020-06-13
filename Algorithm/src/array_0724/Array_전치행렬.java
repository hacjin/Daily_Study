package array_0724;

import java.util.Arrays;

public class Array_전치행렬 {
	public static void main(String[] args) {
		int ary[][] = new int[4][4];
		int i = 0;
		int j = 0;
		int num = 1;

		for (i = 0; i < ary.length; i++) {
			for (j = 0; j < ary.length; j++) {
				ary[i][j] = num++;
			}
		}
		rotate(ary, i, j);
		/**
		 * for-each를 이용해 모든값들을 조회 할때 출력하는 방법도 있다.
		 */
		for(int[] sub : ary ) {
			System.out.println(Arrays.toString(sub));
		}
//		for (i = 0; i < ary.length; i++) {
//			for (j = 0; j < ary.length; j++) {
//				System.out.printf("%d ",ary[i][j]);
//			}
//			System.out.println();
//		}

	}

	public static void rotate(int ary[][], int i, int j) {
		
		int tmp;
		for (i = 0; i < ary.length; i++) {
			for (j = i+1; j < ary.length; j++) {
				tmp = ary[i][j];
				ary[i][j] = ary[j][i];
				ary[j][i] = tmp;
			}
		}

	}
}
