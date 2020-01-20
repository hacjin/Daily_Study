package search_combi_etc_0725;

import java.util.Random;

public class Baby_Gin {
	static int card, N = 6;
	static int numbers[],arr[];

	public static void main(String[] args) {
		Random rd = new Random();
		arr = new int[N];
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			card = rd.nextInt(9) + 1;
			arr[i] = card;
			System.out.printf("%d ", arr[i]);
		}
		System.out.println();
		babygin(0, 0);
	}

	public static void babygin(int index, int selected) {
		if (index == N) {
//			if(isGin()) {
//				return;
//			}
		}
		for (int i = 1; i <= N; i++) {
			if ((selected & 1 << i) == 0) {
				numbers[index] = arr[i];
				babygin(index + 1, selected | 1 << i);
			}
		}
	}
//	public static boolean isGin() {
//	}
//	public static boolean run() {
//		
//	}
//	public static boolean tri() {
//		if(arr[numbers[0]-1] == arr[numbers[1]-1] && arr[numbers[1]-1] == arr[numbers[2]-1]) {
//			return true;
//		}
//	}
}
