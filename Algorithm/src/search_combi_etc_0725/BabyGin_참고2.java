package search_combi_etc_0725;

import java.util.Arrays;
import java.util.Random;

public class BabyGin_참고2 {

	static int[] cards;
	static int n = 6;
	static int arr[];
	static boolean res;
	
	public static void main(String[] args) {
		Random r = new Random();
		cards = new int[n];
		arr = new int[n];
		
		// 6개의 카드 생성
		for(int i=0; i<n; i++) {
			cards[i] = r.nextInt(9)+1;
		}
		
		permutation(0,0);
		
		System.out.println(Arrays.toString(cards));
		System.out.println("결과 : " + res);
	}

	private static void permutation(int selected, int index) {
		// 순열이 하나 완성되면 세개씩 잘라서 확인
		if(index == n) {
			int[] l = Arrays.copyOfRange(arr, 0, 3);  // 자른 왼쪽 부분수열
			int[] r = Arrays.copyOfRange(arr, 3, n);  // 자른 오른쪽 부분수열
			boolean lr = isRun(l);  
			boolean lt = isTriplet(l);
			boolean rr = isRun(r);
			boolean rt = isTriplet(r);
			
			// 왼쪽이 run이거나 triplet이고, 오른쪽이 run이거나 triplet이면 baby-gin이다.
			if((lr || lt) && (rr || rt)) res = true;
			return;
		}
		
		for(int i=0; i<n; i++) {
			if((selected & 1<<i) > 0) continue;  // 이미 해당 인덱스를 골랐다면 넘어감
			arr[index] = cards[i];
			permutation(selected | (1<<i), index+1);
		}
	}
	
	private static boolean isRun(int[] c) {
		Arrays.sort(c);
		// 3개의 수가 연속된 숫자이면 run이다.
		if(c[0]+1 == c[1] && c[1] +1 == c[2]) return true;
		return false;
	}
	
	private static boolean isTriplet(int[] c) {
		// 3개의 수가 모두 같으면 triplet이다.
		if(c[0] == c[1] && c[1] == c[2]) return true;
		return false;
	}
}
