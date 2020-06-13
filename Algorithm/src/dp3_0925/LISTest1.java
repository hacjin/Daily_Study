package dp3_0925;

import java.util.Arrays;
import java.util.Scanner;

public class LISTest1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] arr = new int[N];
		int[] D = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = s.nextInt();
		}

		int size = 0;
		for (int i = 0; i < N; i++) {
			int temp = Arrays.binarySearch(D, 0, size, arr[i]);
			temp = Math.abs(temp) - 1; // 삽입위치
			D[temp] = arr[i];
			if (size == temp)
				size++; // 마지막 위치 삽입
		}

		System.out.println(size);
	}
}