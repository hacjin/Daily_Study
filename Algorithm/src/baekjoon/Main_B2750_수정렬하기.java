package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B2750_수정렬하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int j;
		for (int i = 1; i < N; i++) {
			int min = arr[i];
			for (j = i-1; j >= 0; j--) {
				if(min < arr[j]) {
					arr[j+1] = arr[j];
				}else break;
			}
			arr[j+1] = min;
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}
}
