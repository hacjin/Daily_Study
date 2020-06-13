package permu_combi_bitOper_etc_0816;

import java.util.Arrays;

public class NextPermutation {
	static int N,cnt=1;
	static int number[];
	static int tmp[];
	public static void main(String[] args) {
		N = 4;
		number = new int[] { 1, 2, 3, 4 };
		tmp = new int[] { 0,0,1,1};
		Arrays.sort(number);
		do {
			for (int i = 0; i < N; i++) {
				if(tmp[i]==0) System.out.print(number[i]+" ");
			}
			System.out.println();
//			System.out.println(Arrays.toString(number));
		}while(nextPermutation());
		System.out.println("경우의 수 : "+cnt);
	}

	public static void swap(int i, int j) {
		int tmp;
		tmp = number[i];
		number[i] = number[j];
		number[j] = tmp;
	}
	private static boolean nextPermutation() {
		//1. 뒷쪽부터 왼쪽으로 탐색하며 교환이 필요한 위치 찾기
		int i = N-1;
		while(i>0 && number[i-1]>=number[i]) --i;
		
		// 찾은 위치가 0이면 이미 내림차순된 순열이므로 다음 순열은 없다.
		if(i==0) return false;
		
		//2. i-1위치 : 교환이 필요한 위치
		//	 i-1위치값과 교환할 뒷쪽에서 다음 큰 수 찾기
		int j = N-1;
		while(number[i-1]>=number[j]) --j;
		//3. i-1위치값과 j위치값 교환
		swap(i-1,j);
		//4. i위치부터 끝까지 순열을 오름차순으로 재조정
		j = N-1;
		while(i<j) {
			swap(i++,j--);
		}
		cnt++;
		return true;
	}
}
