package pretest_0717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BubbleSort_참고_review {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine().trim());
		// trim : 뒤에 오는 공백 제거하는 메서드
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		// 처음 받은 String에서 Tokening 반복적인 String 은 불가
		// 반복적인 String의 경우 반복문에 생성을 여러번 해야한다.
		// 구분자가 일정한 패턴이 없을 경우 즉, 여러개의 구분자가 필요할 경우
		int number[] = new int[N];
		// for~each는 조회하는 역할 삽입의 경우는 불가
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		sort(number);
		// countToken() 은 count 갯수 반환 , hasMoreTokens() 토큰의 존재여부를 boolean으로 반환
		System.out.println(Arrays.toString(number));
	}

	/**
	 * static 은 class와 연관되어 있음 static 여부에 따라 new를 사용해 객체를 생성후 사용하는지 아닌지 달라짐
	 * non-static은 instance로 객체에 포함 static은 class에 포함 - algorithm 의 경우 논리적인 실행 파악을
	 * 확인함으로 static을 주로 사용함
	 */
	private static void sort(int[] number) {
		int size = number.length, tmp = 0;
		for (int i = size; i > 0; i--) {
			boolean isSwap = false;					// 정렬이 되어 있는경우 불필요한 반복문이 필요없으니 flag를 이용해 최적화
			for (int j = 0; j < size - 1; j++) {
				if(number[j] > number[j+1]) {
					tmp = number[j];
					number[j] = number[j+1];
					number[j+1] = tmp;
					isSwap = true;
				}				
			}
			System.out.println("sort :" + Arrays.toString(number));
			if(!isSwap) break; 
		}
	}
}
