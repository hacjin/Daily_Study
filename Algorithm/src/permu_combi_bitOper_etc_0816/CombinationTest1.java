package permu_combi_bitOper_etc_0816;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationTest1 {
	
	static int N,R;
	static int[] numbers;
	static boolean[] selected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[R];
		combination(1,0);
	}
	private static void combination(int index,int count) {
		if(count == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		if(index<=N) {
			numbers[count] = index;
			combination(index+1,count+1);
			
			combination(index+1,count);
		}
	}
}
