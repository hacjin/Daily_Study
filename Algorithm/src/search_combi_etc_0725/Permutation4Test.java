package search_combi_etc_0725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * N 이 클경우는 
 * N-1 까지의 비교하는 연산이 처리되므로
 * flag 배열을 이용하여 flag값만 비교하여 전에 나온 값들을 확인
 *	비트 마스크를 이용한 방법
 *	비트 맨오른쪽 위치를 배열 0 index와 같게 사용된다
 */
public class Permutation4Test {
	static int N,R, numbers[];
	static int totalCount=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		R = Integer.parseInt(in.readLine());
		numbers = new int[R];

		permutation(0,0);
		System.out.println("경우의 수 :" +totalCount);
	}
	
	private static void permutation(int index,int selected) {
		
		if(index == R) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= N; i++) {
			if((selected & 1<<i) == 0) {			// 해당 수가 선택되지 않았는지 파악
				numbers[index] = i;
//				selected = selected | 1<<i;			
// 				selected에 flag 처리후 되돌아 올때 unflag 하기 위해선
//				복잡하니 인자로 selected | 1<<i 를 넘겨 주면 
//				return 후 selected는 변화가 없으니 이렇게 사용한다.
				permutation(index+1,selected | 1<<i);// 현재 선택한수 사용한 플래그 처리
			}
		}
	}
}
