package queue_linkedList_sort_etc_0808;

import java.util.Arrays;

public class InsertionSortTest {
	
	public static void insertionSrot(int list[]) {
		final int SIZE = list.length;
		for (int i = 1; i < SIZE; i++) {	// 정렬되지 않은 집합
			int tmp = list[i];	// 정렬되야하는 원소
			for (int j = 0; j < i; j++) {	// 정렬된 집합
				if(tmp < list[j]) {			// 삽입지점을 찾았다면
					for (int k = i-1; k >= j ; k--) {	// 정렬된 집합의 맨 뒤부터 삽입지점까지 뒤로 민다.
						list[k+1] = list[k];
					}
					list[j] = tmp;	// 삽입지점에 원소 넣기
					break;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] list = { 69,10,30,2,16 ,8,31,22,10,16};
		System.out.println(Arrays.toString(list));
		insertionSrot(list);
		System.out.println(Arrays.toString(list));
	}
}
