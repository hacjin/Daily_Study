package search_combi_etc_0725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BabyGin_참고1 {
	static int N, R, numbers[], output[];
	static int[] input = {0,5,4,0,6,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		N = Integer.parseInt(br.readLine());
//		R = Integer.parseInt(br.readLine());
		R = 6;
		numbers = new int[R];
		output = new int[R];
		
		
		if(permutation(0, 0)) {
			System.out.println(Arrays.toString(input) + "는 Baby-gin입니다.");
			System.out.println(Arrays.toString(output));
		}
		else System.out.println(Arrays.toString(input) + "는 Baby-gin이 아닙니다.");
		
	}
	
	private static boolean permutation(int index, int selected) {
		boolean result=false;
		if(index == R) {
			boolean front = (numbers[0] == numbers[1] && numbers[0] == numbers[2]) 
					|| (numbers[0]+1 == numbers[1] && numbers[0]+2 == numbers[2]);
			boolean back = (numbers[3] == numbers[4] && numbers[3] == numbers[5]) 
					|| (numbers[3]+1 == numbers[4] && numbers[3]+2 == numbers[5]);
			result = front && back;
			
			if(result) output = Arrays.copyOf(numbers, R);

			return result;
		}
		for(int i = 0; i < R; ++i) {
			if((selected & 1<<i) == 0) {
				numbers[index] = input[i];
				if(!result) result = result || permutation(index+1, selected | 1<<i);
			}
		}
		return result;
	}

}
