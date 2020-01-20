package queue_linkedList_sort_etc_0808;

import java.util.Arrays;

public class MergeSortTest {
	public static void mergeSort(int list[], int start, int end) {
		if(start == end) return;	// 집합의 크기가 1이므로 분할불가(이미 정렬완료)
		int middle = (start + end) /2;
		mergeSort(list,start,middle);	// 중간위치값 왼쪽집합에 포함 
		mergeSort(list,middle+1,end);	// 중간위치값 오른쪽집합에 포함
		merge(list,start,middle,end);	// 병합하는 함수
	}
	
	private static void merge(int[] list, int start, int middle, int end) {
		int left = start, right = middle+1;
		int i=0;	// 새롭게 채워질 배열의 인덱스
		int[] nArr = new int[end-start+1];
		
		do {
			if (list[left] < list[right]) {
				nArr[i++] = list[left++];
			} else {
				nArr[i++] = list[right++];
			} 
		} while (left<=middle && right<=end);
		
		// 오른쪽 집합이 다 처리된 경우 , 남은 왼쪽 집합 처리
		while(left<=middle) nArr[i++] = list[left++];
		// 왼쪽 집합이 다 처리된 경우 , 남은 오른쪽 집합 처리
		while(right<=end) nArr[i++] = list[right++];
		
		System.arraycopy(nArr, 0, list, start, nArr.length);
		
	}

	public static void main(String[] args) {
		int[] list = { 69,10,30,2,16,8,31,22,10,16 };
		System.out.println(Arrays.toString(list));
		mergeSort(list,0,list.length-1);
		System.out.println(Arrays.toString(list));
	}
}
