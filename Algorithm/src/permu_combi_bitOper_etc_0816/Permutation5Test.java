package permu_combi_bitOper_etc_0816;

import java.util.Arrays;

public class Permutation5Test {
	
	static int N;
	static int[] numbers;
	public static void main(String[] args) {
		N= 4;
		numbers = new int[] {1,2,3,4};
		permutation(0);
	}
	private static void permutation(int index) {
		if(index==N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = index; i < N; i++) {
			swap(index,i);
			permutation(index+1);
			swap(i,index);
		}
	}
	
	private static void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
