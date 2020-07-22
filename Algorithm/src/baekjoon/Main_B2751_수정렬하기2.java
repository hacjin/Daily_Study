package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B2751_수정렬하기2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int arr[] = new int[T];
		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		quick_sort(arr,0,T-1);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	public static int partition(int[] arr,int s, int e) {
		int mid = (s+e)/2;
		swap(arr,s,mid);
		int pivot = s;
		int left = s;
		int right = e+1;
		do {
			do {
				left++;
			} while(e>= left && arr[pivot] > arr[left]);
			
			do {
				right--;
			} while (s<=right && arr[pivot] < arr[right]);
			
			if(left<right) swap(arr,left,right);
			
		} while (left<right);
		
		swap(arr,pivot,right);
		
		return right;
		
	}
	public static void quick_sort(int[] arr, int s, int e) {
		if(s<e) {
			int pivot = partition(arr,s,e);
			quick_sort(arr, s, pivot-1);
			quick_sort(arr, pivot+1, e);
		}
	}
	
	public static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
