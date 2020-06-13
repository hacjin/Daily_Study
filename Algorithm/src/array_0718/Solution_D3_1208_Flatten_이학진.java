package array_0718;

import java.util.Scanner;
/**
 *
 * 강사님 Review
 * 1. 높은 높이의 수들의 갯수를 카운팅.
 * ex ) 0 1 2 3 4 5 6 7 8 9 높이
 * 갯수    0 1 2 1 1 2 1 0 1 2 개
 * min 가장 낮은 높이 = 1
 * max 가장 높은 높이 = 9
 * 
 * max -> min 에 이동시
 * ex ) 0 1 2 3 4 5 6 7 8 9 높이
 * 갯수    0 0 3 1 1 2 1 0 2 1 개
 * min 가장 낮은 높이 = 2
 * max 가장 높은 높이 = 9 
 *
 */
public class Solution_D3_1208_Flatten_이학진 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = 100;
		int dump;
		int data[] = new int[size];
		int T = 10;
		int max = 0, min = 0;
		int max_i = 0, min_i = 0;

		while (T > 0) {
			dump = sc.nextInt();
			if (dump < 0 || dump > 1000) {
				T++;
			}
			for (int i = 0; i < size; i++) {
				data[i] = sc.nextInt();
				if (data[i] < 0 || data[i] > 100) {
					i--;
				}
//				0~99 인덱스에 1~100까지의 값이 들어온다
			}

			for (int j = dump; j >= 0; j--) {
				max = 0;
				min = 100;
				for (int i = 0; i < size; i++) {
					if (data[i] > max) {
						max = data[i];
						max_i = i;
					}
					if (data[i] < min) {
						min = data[i];
						min_i = i;
					}
				}
				int diff = data[max_i] - data[min_i];
				if(diff == 0 || diff == 1) { break; }
				if(j!=0) {
					data[max_i]--;
					data[min_i]++;
				}
			}
			T--;
			System.out.println("#" + (10 - T) + " " + (max - min));
		}
	}
}
