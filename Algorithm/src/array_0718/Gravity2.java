package array_0718;

import java.util.Random;

public class Gravity2 {
	static int size = 9, value = 0;

	public static void main(String[] args) {
		int R[][] = new int[size][size]; // 방의 길이 100x100
		int depth[] = new int[size];
		int high=0,low=0;
		build_data(R, depth);

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < depth[i]; j++) {
				if(R[i][j]==1) {
					high = i;
					low = j;
				}
			}
		}

		System.out.println("Max_difference_depth : " + (high-low));
//		ex) R[0] = 100 이면  회전을 통해 배열을 생각시 0열에 100개의 높이로 이루어져 있다고 생각 가능하다. 

	}

	private static void build_data(int[][] R, int[] depth) {

		Random ran = new Random();
		for (int i = 0; i < size; i++) {
			value = ran.nextInt(size + 1);
			for (int j = 0; j < value; j++) {
				R[j][i]++;
				if (R[j][i] == 1) {
					depth[i]++;
				}
			}
		}
	}

}
