package permu_combi_bitOper_etc_0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * N 이 클경우는 
 * N-1 까지의 비교하는 연산이 처리되므로
 * flag 배열을 이용하여 flag값만 비교하여 전에 나온 값들을 확인
 *
 */
public class Permutation3Test {
	static int N,R, numbers[];
	static boolean[] selected;
	static int totalCount=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		R = N;
		numbers = new int[N];
		selected = new boolean[N+1];
		permutation(0);
		System.out.println("경우의 수 :" +totalCount);
	}
	
	private static void permutation(int index) {
		if(index == R) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= N; i++) {
			if(!selected[i]) {			// 해당 수가 선택되지 않았다면
				numbers[index] = i;
				selected[i] = true;		// 현재 선택한수 사용한 플래그 처리
				permutation(index+1);
				selected[i] = false;
			}
		}
	}
}
