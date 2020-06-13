package recursive_0724;

import java.util.Scanner;
/**
 * 
 *	이진탐색 : 중간인덱스를 기준으로 찾는 값이 작을때 왼쪽 클때 오른쪽을 탐색 찾을때 까지 이를 반복
 *	s : 0 index  e : Max = 6
 *	middle : s+e/2
 *	index 	 0 1 2 3 4  5  6
 *	ex ) 	 2 4 7 9 11 19 32
 *	middle index 3: 9값
 *  find value : 7 일 경우 
 *  중간값보다 작을경우
 *  e = middle -1;
 *  중간값보다 클 경우
 *  s = middle +1;
 *  
 *   s는 e에 가까워 지고 s>e 커질경우는 찾지 못한 경우
 *   
 *				
 */
public class BinarySearch1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[];
		int N;
		int f;
		N = sc.nextInt();
		arr = new int[N];
		int s = 0, e = N-1;
		int key;
		boolean find = false;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		f = sc.nextInt(); // 찾을 값

		while (true) {
			key = (e + s) / 2;
			if (f < arr[key]) {
				e = key-1;
			} else if (f == arr[key]) {
				System.out.println("검색한 "+f+"는 "+(key+1)+"번째 배열에 위치.");
				break;
			} else {
				s = key+1;
			}
			if (s>e) {
				System.out.println("검색한 값이 존재하지 않습니다.");
				break;
			}

		}
	}
}
